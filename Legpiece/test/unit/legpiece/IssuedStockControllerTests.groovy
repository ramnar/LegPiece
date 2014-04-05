package legpiece



import org.junit.*
import grails.test.mixin.*

@TestFor(IssuedStockController)
@Mock(IssuedStock)
class IssuedStockControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/issuedStock/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.issuedStockInstanceList.size() == 0
        assert model.issuedStockInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.issuedStockInstance != null
    }

    void testSave() {
        controller.save()

        assert model.issuedStockInstance != null
        assert view == '/issuedStock/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/issuedStock/show/1'
        assert controller.flash.message != null
        assert IssuedStock.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/issuedStock/list'

        populateValidParams(params)
        def issuedStock = new IssuedStock(params)

        assert issuedStock.save() != null

        params.id = issuedStock.id

        def model = controller.show()

        assert model.issuedStockInstance == issuedStock
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/issuedStock/list'

        populateValidParams(params)
        def issuedStock = new IssuedStock(params)

        assert issuedStock.save() != null

        params.id = issuedStock.id

        def model = controller.edit()

        assert model.issuedStockInstance == issuedStock
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/issuedStock/list'

        response.reset()

        populateValidParams(params)
        def issuedStock = new IssuedStock(params)

        assert issuedStock.save() != null

        // test invalid parameters in update
        params.id = issuedStock.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/issuedStock/edit"
        assert model.issuedStockInstance != null

        issuedStock.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/issuedStock/show/$issuedStock.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        issuedStock.clearErrors()

        populateValidParams(params)
        params.id = issuedStock.id
        params.version = -1
        controller.update()

        assert view == "/issuedStock/edit"
        assert model.issuedStockInstance != null
        assert model.issuedStockInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/issuedStock/list'

        response.reset()

        populateValidParams(params)
        def issuedStock = new IssuedStock(params)

        assert issuedStock.save() != null
        assert IssuedStock.count() == 1

        params.id = issuedStock.id

        controller.delete()

        assert IssuedStock.count() == 0
        assert IssuedStock.get(issuedStock.id) == null
        assert response.redirectedUrl == '/issuedStock/list'
    }
}
