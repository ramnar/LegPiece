package legpiece

import org.springframework.dao.DataIntegrityViolationException

class IssuedStockController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [issuedStockInstanceList: IssuedStock.list(params), issuedStockInstanceTotal: IssuedStock.count()]
    }

    def create() {
        [issuedStockInstance: new IssuedStock(params)]
    }

    def save() {
        def issuedStockInstance = new IssuedStock(params)
        if (!issuedStockInstance.save(flush: true)) {
            render(view: "create", model: [issuedStockInstance: issuedStockInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'issuedStock.label', default: 'IssuedStock'), issuedStockInstance.id])
        redirect(action: "show", id: issuedStockInstance.id)
    }

    def show(Long id) {
        def issuedStockInstance = IssuedStock.get(id)
        if (!issuedStockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'issuedStock.label', default: 'IssuedStock'), id])
            redirect(action: "list")
            return
        }

        [issuedStockInstance: issuedStockInstance]
    }

    def edit(Long id) {
        def issuedStockInstance = IssuedStock.get(id)
        if (!issuedStockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'issuedStock.label', default: 'IssuedStock'), id])
            redirect(action: "list")
            return
        }

        [issuedStockInstance: issuedStockInstance]
    }

    def update(Long id, Long version) {
        def issuedStockInstance = IssuedStock.get(id)
        if (!issuedStockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'issuedStock.label', default: 'IssuedStock'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (issuedStockInstance.version > version) {
                issuedStockInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'issuedStock.label', default: 'IssuedStock')] as Object[],
                          "Another user has updated this IssuedStock while you were editing")
                render(view: "edit", model: [issuedStockInstance: issuedStockInstance])
                return
            }
        }

        issuedStockInstance.properties = params

        if (!issuedStockInstance.save(flush: true)) {
            render(view: "edit", model: [issuedStockInstance: issuedStockInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'issuedStock.label', default: 'IssuedStock'), issuedStockInstance.id])
        redirect(action: "show", id: issuedStockInstance.id)
    }

    def delete(Long id) {
        def issuedStockInstance = IssuedStock.get(id)
        if (!issuedStockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'issuedStock.label', default: 'IssuedStock'), id])
            redirect(action: "list")
            return
        }

        try {
            issuedStockInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'issuedStock.label', default: 'IssuedStock'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'issuedStock.label', default: 'IssuedStock'), id])
            redirect(action: "show", id: id)
        }
    }
}
