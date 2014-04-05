package legpiece



import org.junit.*
import grails.test.mixin.*

@TestFor(AvailableStockController)
@Mock(AvailableStock)
class AvailableStockControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/availableStock/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.availableStockInstanceList.size() == 0
        assert model.availableStockInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.availableStockInstance != null
    }

    void testSave() {
        controller.save()

        assert model.availableStockInstance != null
        assert view == '/availableStock/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/availableStock/show/1'
        assert controller.flash.message != null
        assert AvailableStock.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/availableStock/list'

        populateValidParams(params)
        def availableStock = new AvailableStock(params)

        assert availableStock.save() != null

        params.id = availableStock.id

        def model = controller.show()

        assert model.availableStockInstance == availableStock
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/availableStock/list'

        populateValidParams(params)
        def availableStock = new AvailableStock(params)

        assert availableStock.save() != null

        params.id = availableStock.id

        def model = controller.edit()

        assert model.availableStockInstance == availableStock
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/availableStock/list'

        response.reset()

        populateValidParams(params)
        def availableStock = new AvailableStock(params)

        assert availableStock.save() != null

        // test invalid parameters in update
        params.id = availableStock.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/availableStock/edit"
        assert model.availableStockInstance != null

        availableStock.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/availableStock/show/$availableStock.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        availableStock.clearErrors()

        populateValidParams(params)
        params.id = availableStock.id
        params.version = -1
        controller.update()

        assert view == "/availableStock/edit"
        assert model.availableStockInstance != null
        assert model.availableStockInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/availableStock/list'

        response.reset()

        populateValidParams(params)
        def availableStock = new AvailableStock(params)

        assert availableStock.save() != null
        assert AvailableStock.count() == 1

        params.id = availableStock.id

        controller.delete()

        assert AvailableStock.count() == 0
        assert AvailableStock.get(availableStock.id) == null
        assert response.redirectedUrl == '/availableStock/list'
    }
}
