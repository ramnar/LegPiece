package legpiece



import org.junit.*
import grails.test.mixin.*

@TestFor(KitchenController)
@Mock(Kitchen)
class KitchenControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/kitchen/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.kitchenInstanceList.size() == 0
        assert model.kitchenInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.kitchenInstance != null
    }

    void testSave() {
        controller.save()

        assert model.kitchenInstance != null
        assert view == '/kitchen/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/kitchen/show/1'
        assert controller.flash.message != null
        assert Kitchen.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/kitchen/list'

        populateValidParams(params)
        def kitchen = new Kitchen(params)

        assert kitchen.save() != null

        params.id = kitchen.id

        def model = controller.show()

        assert model.kitchenInstance == kitchen
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/kitchen/list'

        populateValidParams(params)
        def kitchen = new Kitchen(params)

        assert kitchen.save() != null

        params.id = kitchen.id

        def model = controller.edit()

        assert model.kitchenInstance == kitchen
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/kitchen/list'

        response.reset()

        populateValidParams(params)
        def kitchen = new Kitchen(params)

        assert kitchen.save() != null

        // test invalid parameters in update
        params.id = kitchen.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/kitchen/edit"
        assert model.kitchenInstance != null

        kitchen.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/kitchen/show/$kitchen.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        kitchen.clearErrors()

        populateValidParams(params)
        params.id = kitchen.id
        params.version = -1
        controller.update()

        assert view == "/kitchen/edit"
        assert model.kitchenInstance != null
        assert model.kitchenInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/kitchen/list'

        response.reset()

        populateValidParams(params)
        def kitchen = new Kitchen(params)

        assert kitchen.save() != null
        assert Kitchen.count() == 1

        params.id = kitchen.id

        controller.delete()

        assert Kitchen.count() == 0
        assert Kitchen.get(kitchen.id) == null
        assert response.redirectedUrl == '/kitchen/list'
    }
}
