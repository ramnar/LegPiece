package legpiece

import org.springframework.dao.DataIntegrityViolationException

class VendorController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [vendorInstanceList: Vendor.list(params), vendorInstanceTotal: Vendor.count()]
    }

    def create() {
        [vendorInstance: new Vendor(params)]
    }

    def save() {
        def vendorInstance = new Vendor(params)
        if (!vendorInstance.save(flush: true)) {
            render(view: "create", model: [vendorInstance: vendorInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'vendor.label', default: 'Vendor'), vendorInstance.id])
        redirect(action: "show", id: vendorInstance.id)
    }

    def show(Long id) {
        def vendorInstance = Vendor.get(id)
        if (!vendorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendor.label', default: 'Vendor'), id])
            redirect(action: "list")
            return
        }

        [vendorInstance: vendorInstance]
    }

    def edit(Long id) {
        def vendorInstance = Vendor.get(id)
        if (!vendorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendor.label', default: 'Vendor'), id])
            redirect(action: "list")
            return
        }

        [vendorInstance: vendorInstance]
    }

    def update(Long id, Long version) {
        def vendorInstance = Vendor.get(id)
        if (!vendorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendor.label', default: 'Vendor'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (vendorInstance.version > version) {
                vendorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'vendor.label', default: 'Vendor')] as Object[],
                          "Another user has updated this Vendor while you were editing")
                render(view: "edit", model: [vendorInstance: vendorInstance])
                return
            }
        }

        vendorInstance.properties = params

        if (!vendorInstance.save(flush: true)) {
            render(view: "edit", model: [vendorInstance: vendorInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'vendor.label', default: 'Vendor'), vendorInstance.id])
        redirect(action: "show", id: vendorInstance.id)
    }

    def delete(Long id) {
        def vendorInstance = Vendor.get(id)
        if (!vendorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendor.label', default: 'Vendor'), id])
            redirect(action: "list")
            return
        }

        try {
            vendorInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendor.label', default: 'Vendor'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'vendor.label', default: 'Vendor'), id])
            redirect(action: "show", id: id)
        }
    }
}
