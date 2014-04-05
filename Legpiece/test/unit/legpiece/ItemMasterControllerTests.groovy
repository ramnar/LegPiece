package legpiece



import org.junit.*
import grails.test.mixin.*

@TestFor(ItemMasterController)
@Mock(ItemMaster)
class ItemMasterControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/itemMaster/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.itemMasterInstanceList.size() == 0
        assert model.itemMasterInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.itemMasterInstance != null
    }

    void testSave() {
        controller.save()

        assert model.itemMasterInstance != null
        assert view == '/itemMaster/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/itemMaster/show/1'
        assert controller.flash.message != null
        assert ItemMaster.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/itemMaster/list'

        populateValidParams(params)
        def itemMaster = new ItemMaster(params)

        assert itemMaster.save() != null

        params.id = itemMaster.id

        def model = controller.show()

        assert model.itemMasterInstance == itemMaster
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/itemMaster/list'

        populateValidParams(params)
        def itemMaster = new ItemMaster(params)

        assert itemMaster.save() != null

        params.id = itemMaster.id

        def model = controller.edit()

        assert model.itemMasterInstance == itemMaster
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/itemMaster/list'

        response.reset()

        populateValidParams(params)
        def itemMaster = new ItemMaster(params)

        assert itemMaster.save() != null

        // test invalid parameters in update
        params.id = itemMaster.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/itemMaster/edit"
        assert model.itemMasterInstance != null

        itemMaster.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/itemMaster/show/$itemMaster.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        itemMaster.clearErrors()

        populateValidParams(params)
        params.id = itemMaster.id
        params.version = -1
        controller.update()

        assert view == "/itemMaster/edit"
        assert model.itemMasterInstance != null
        assert model.itemMasterInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/itemMaster/list'

        response.reset()

        populateValidParams(params)
        def itemMaster = new ItemMaster(params)

        assert itemMaster.save() != null
        assert ItemMaster.count() == 1

        params.id = itemMaster.id

        controller.delete()

        assert ItemMaster.count() == 0
        assert ItemMaster.get(itemMaster.id) == null
        assert response.redirectedUrl == '/itemMaster/list'
    }
}
