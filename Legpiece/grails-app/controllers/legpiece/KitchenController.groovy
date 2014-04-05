package legpiece

import org.springframework.dao.DataIntegrityViolationException

class KitchenController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [kitchenInstanceList: Kitchen.list(params), kitchenInstanceTotal: Kitchen.count()]
    }

    def create() {
        [kitchenInstance: new Kitchen(params)]
    }

    def save() {
        def kitchenInstance = new Kitchen(params)
        if (!kitchenInstance.save(flush: true)) {
            render(view: "create", model: [kitchenInstance: kitchenInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'kitchen.label', default: 'Kitchen'), kitchenInstance.id])
        redirect(action: "show", id: kitchenInstance.id)
    }

    def show(Long id) {
        def kitchenInstance = Kitchen.get(id)
        if (!kitchenInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'kitchen.label', default: 'Kitchen'), id])
            redirect(action: "list")
            return
        }

        [kitchenInstance: kitchenInstance]
    }

    def edit(Long id) {
        def kitchenInstance = Kitchen.get(id)
        if (!kitchenInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'kitchen.label', default: 'Kitchen'), id])
            redirect(action: "list")
            return
        }

        [kitchenInstance: kitchenInstance]
    }

    def update(Long id, Long version) {
        def kitchenInstance = Kitchen.get(id)
        if (!kitchenInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'kitchen.label', default: 'Kitchen'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (kitchenInstance.version > version) {
                kitchenInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'kitchen.label', default: 'Kitchen')] as Object[],
                          "Another user has updated this Kitchen while you were editing")
                render(view: "edit", model: [kitchenInstance: kitchenInstance])
                return
            }
        }

        kitchenInstance.properties = params

        if (!kitchenInstance.save(flush: true)) {
            render(view: "edit", model: [kitchenInstance: kitchenInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'kitchen.label', default: 'Kitchen'), kitchenInstance.id])
        redirect(action: "show", id: kitchenInstance.id)
    }

    def delete(Long id) {
        def kitchenInstance = Kitchen.get(id)
        if (!kitchenInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'kitchen.label', default: 'Kitchen'), id])
            redirect(action: "list")
            return
        }

        try {
            kitchenInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'kitchen.label', default: 'Kitchen'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'kitchen.label', default: 'Kitchen'), id])
            redirect(action: "show", id: id)
        }
    }
}
