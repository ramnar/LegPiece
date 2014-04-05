package legpiece

import org.springframework.dao.DataIntegrityViolationException

class PurchasedStockController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [purchasedStockInstanceList: PurchasedStock.list(params), purchasedStockInstanceTotal: PurchasedStock.count()]
    }

    def create() {
        [purchasedStockInstance: new PurchasedStock(params)]
    }

    def save() {
        def purchasedStockInstance = new PurchasedStock(params)
        if (!purchasedStockInstance.save(flush: true)) {
            render(view: "create", model: [purchasedStockInstance: purchasedStockInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'purchasedStock.label', default: 'PurchasedStock'), purchasedStockInstance.id])
        redirect(action: "show", id: purchasedStockInstance.id)
    }

    def show(Long id) {
        def purchasedStockInstance = PurchasedStock.get(id)
        if (!purchasedStockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'purchasedStock.label', default: 'PurchasedStock'), id])
            redirect(action: "list")
            return
        }

        [purchasedStockInstance: purchasedStockInstance]
    }

    def edit(Long id) {
        def purchasedStockInstance = PurchasedStock.get(id)
        if (!purchasedStockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'purchasedStock.label', default: 'PurchasedStock'), id])
            redirect(action: "list")
            return
        }

        [purchasedStockInstance: purchasedStockInstance]
    }

    def update(Long id, Long version) {
        def purchasedStockInstance = PurchasedStock.get(id)
        if (!purchasedStockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'purchasedStock.label', default: 'PurchasedStock'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (purchasedStockInstance.version > version) {
                purchasedStockInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'purchasedStock.label', default: 'PurchasedStock')] as Object[],
                          "Another user has updated this PurchasedStock while you were editing")
                render(view: "edit", model: [purchasedStockInstance: purchasedStockInstance])
                return
            }
        }

        purchasedStockInstance.properties = params

        if (!purchasedStockInstance.save(flush: true)) {
            render(view: "edit", model: [purchasedStockInstance: purchasedStockInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'purchasedStock.label', default: 'PurchasedStock'), purchasedStockInstance.id])
        redirect(action: "show", id: purchasedStockInstance.id)
    }

    def delete(Long id) {
        def purchasedStockInstance = PurchasedStock.get(id)
        if (!purchasedStockInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'purchasedStock.label', default: 'PurchasedStock'), id])
            redirect(action: "list")
            return
        }

        try {
            purchasedStockInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'purchasedStock.label', default: 'PurchasedStock'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'purchasedStock.label', default: 'PurchasedStock'), id])
            redirect(action: "show", id: id)
        }
    }
}
