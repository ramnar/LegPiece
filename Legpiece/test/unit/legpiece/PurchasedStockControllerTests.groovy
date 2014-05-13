package legpiece



import org.junit.*
import grails.test.mixin.*

@TestFor(PurchasedStockController)
@Mock(PurchasedStock)
class PurchasedStockControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/purchasedStock/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.purchasedStockInstanceList.size() == 0
        assert model.purchasedStockInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.purchasedStockInstance != null
    }

    void testSave() {
        controller.save()

        assert model.purchasedStockInstance != null
        assert view == '/purchasedStock/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/purchasedStock/show/1'
        assert controller.flash.message != null
        assert PurchasedStock.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/purchasedStock/list'

        populateValidParams(params)
        def purchasedStock = new PurchasedStock(params)

        assert purchasedStock.save() != null

        params.id = purchasedStock.id

        def model = controller.show()

        assert model.purchasedStockInstance == purchasedStock
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/purchasedStock/list'

        populateValidParams(params)
        def purchasedStock = new PurchasedStock(params)

        assert purchasedStock.save() != null

        params.id = purchasedStock.id

        def model = controller.edit()

        assert model.purchasedStockInstance == purchasedStock
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/purchasedStock/list'

        response.reset()

        populateValidParams(params)
        def purchasedStock = new PurchasedStock(params)

        assert purchasedStock.save() != null

        // test invalid parameters in update
        params.id = purchasedStock.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/purchasedStock/edit"
        assert model.purchasedStockInstance != null

        purchasedStock.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/purchasedStock/show/$purchasedStock.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        purchasedStock.clearErrors()

        populateValidParams(params)
        params.id = purchasedStock.id
        params.version = -1
        controller.update()

        assert view == "/purchasedStock/edit"
        assert model.purchasedStockInstance != null
        assert model.purchasedStockInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/purchasedStock/list'

        response.reset()

        populateValidParams(params)
        def purchasedStock = new PurchasedStock(params)

        assert purchasedStock.save() != null
        assert PurchasedStock.count() == 1

        params.id = purchasedStock.id

        controller.delete()

        assert PurchasedStock.count() == 0
        assert PurchasedStock.get(purchasedStock.id) == null
        assert response.redirectedUrl == '/purchasedStock/list'
    }
}
