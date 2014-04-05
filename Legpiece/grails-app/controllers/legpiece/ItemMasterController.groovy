package legpiece

import org.springframework.dao.DataIntegrityViolationException

class ItemMasterController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [itemMasterInstanceList: ItemMaster.list(params), itemMasterInstanceTotal: ItemMaster.count()]
    }

    def create() {
        [itemMasterInstance: new ItemMaster(params)]
    }

    def save() {
        def itemMasterInstance = new ItemMaster(params)
        if (!itemMasterInstance.save(flush: true)) {
            render(view: "create", model: [itemMasterInstance: itemMasterInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'itemMaster.label', default: 'ItemMaster'), itemMasterInstance.id])
        redirect(action: "show", id: itemMasterInstance.id)
    }

    def show(Long id) {
        def itemMasterInstance = ItemMaster.get(id)
        if (!itemMasterInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemMaster.label', default: 'ItemMaster'), id])
            redirect(action: "list")
            return
        }

        [itemMasterInstance: itemMasterInstance]
    }

    def edit(Long id) {
        def itemMasterInstance = ItemMaster.get(id)
        if (!itemMasterInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemMaster.label', default: 'ItemMaster'), id])
            redirect(action: "list")
            return
        }

        [itemMasterInstance: itemMasterInstance]
    }

    def update(Long id, Long version) {
        def itemMasterInstance = ItemMaster.get(id)
        if (!itemMasterInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemMaster.label', default: 'ItemMaster'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (itemMasterInstance.version > version) {
                itemMasterInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'itemMaster.label', default: 'ItemMaster')] as Object[],
                          "Another user has updated this ItemMaster while you were editing")
                render(view: "edit", model: [itemMasterInstance: itemMasterInstance])
                return
            }
        }

        itemMasterInstance.properties = params

        if (!itemMasterInstance.save(flush: true)) {
            render(view: "edit", model: [itemMasterInstance: itemMasterInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'itemMaster.label', default: 'ItemMaster'), itemMasterInstance.id])
        redirect(action: "show", id: itemMasterInstance.id)
    }

    def delete(Long id) {
        def itemMasterInstance = ItemMaster.get(id)
        if (!itemMasterInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemMaster.label', default: 'ItemMaster'), id])
            redirect(action: "list")
            return
        }

        try {
            itemMasterInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'itemMaster.label', default: 'ItemMaster'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'itemMaster.label', default: 'ItemMaster'), id])
            redirect(action: "show", id: id)
        }
    }
}
