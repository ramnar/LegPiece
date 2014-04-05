package legpiece

import org.springframework.dao.DataIntegrityViolationException

class AvailableStockController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [availableStockInstanceList: AvailableStock.list(params), availableStockInstanceTotal: AvailableStock.count()]
    }

    def create() {
        [availableStockInstance: new AvailableStock(params)]
    }

    def save() {
        def availableStockInstance = new AvailableStock(params)
        if (!availableStockInstance.save(flush: true)) {
            render(view: "create", model: [availableStockInstance: availableStockInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'availableStock.label', default: 'AvailableStock'), availableStockInstance.id])
        redirect(action: "show", id: availableStockInstance.id)
    }

    def show(Long id) {
        def availableStockInstance = AvailableStock.get(id)
        if (!availableStockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'availableStock.label', default: 'AvailableStock'), id])
            redirect(action: "list")
            return
        }

        [availableStockInstance: availableStockInstance]
    }

    def edit(Long id) {
        def availableStockInstance = AvailableStock.get(id)
        if (!availableStockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'availableStock.label', default: 'AvailableStock'), id])
            redirect(action: "list")
            return
        }

        [availableStockInstance: availableStockInstance]
    }

    def update(Long id, Long version) {
        def availableStockInstance = AvailableStock.get(id)
        if (!availableStockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'availableStock.label', default: 'AvailableStock'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (availableStockInstance.version > version) {
                availableStockInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'availableStock.label', default: 'AvailableStock')] as Object[],
                          "Another user has updated this AvailableStock while you were editing")
                render(view: "edit", model: [availableStockInstance: availableStockInstance])
                return
            }
        }

        availableStockInstance.properties = params

        if (!availableStockInstance.save(flush: true)) {
            render(view: "edit", model: [availableStockInstance: availableStockInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'availableStock.label', default: 'AvailableStock'), availableStockInstance.id])
        redirect(action: "show", id: availableStockInstance.id)
    }

    def delete(Long id) {
        def availableStockInstance = AvailableStock.get(id)
        if (!availableStockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'availableStock.label', default: 'AvailableStock'), id])
            redirect(action: "list")
            return
        }

        try {
            availableStockInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'availableStock.label', default: 'AvailableStock'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'availableStock.label', default: 'AvailableStock'), id])
            redirect(action: "show", id: id)
        }
    }
}
