import com.example.travelua.models.Travel
import com.example.travelua.repositories.TravelRepository
import com.example.travelua.services.TravelService
import spock.lang.Specification

class TravelServiceTest extends Specification {
    private final travelRepository = Mock(TravelRepository)
    private final travelService = new TravelService(travelRepository)
    private final NAME = "Блакитні озера Чернігівщини"
    private final CITY = "м. Чернігів"
    private final FROM_DATE = "2023-04-03"
    private final TO_DATE = "2023-04-04"
    private final PRICE = 900L
    private final DESCRIPTION = "Активності"

    def "Save new travel"() {
        setup:
        def travel = new Travel(1L, NAME, CITY, FROM_DATE, TO_DATE, PRICE, DESCRIPTION)

        when:
        travelService.saveNewTravel(travel)

        then:
        1 * travelRepository.save(travel)

        and:
        0 * _._
    }

    def "Get all travels"() {
        setup:
        def travel = [new Travel(1L, NAME, CITY, FROM_DATE, TO_DATE, PRICE, DESCRIPTION)]

        when:
        def result = travelService.getAllTravels()

        then:
        1 * travelRepository.findAll() >> travel

        and:
        result == travel

        and:
        0 * _._
    }

    def "Get all travels by fromDate"() {
        setup:
        def travel = [new Travel(1L, NAME, CITY, FROM_DATE, TO_DATE, PRICE, DESCRIPTION)]

        when:
        def result = travelService.getAllTravelsByFromDate(FROM_DATE)

        then:
        1 * travelRepository.findByFromDate(FROM_DATE) >> travel

        and:
        result == travel

        and:
        0 * _._
    }

    def "Delete all travels by fromDate"() {
        when:
        travelService.deleteAllTravelsByFromDate(FROM_DATE)

        then:
        1 * travelRepository.deleteAllByFromDate(FROM_DATE)

        and:
        0 * _._
    }

    def "Get all travels by fromDate and toDate"() {
        setup:
        def travel = [new Travel(1L, NAME, CITY, FROM_DATE, TO_DATE, PRICE, DESCRIPTION)]

        when:
        def result = travelService.getAllTravelsByFromDateAndToDate(FROM_DATE, TO_DATE)

        then:
        1 * travelRepository.findAllByFromDateAndToDate(FROM_DATE, TO_DATE) >> travel

        and:
        result == travel

        and:
        0 * _._
    }

    def "Get all travels by city"() {
        setup:
        def travel = [new Travel(1L, NAME, CITY, FROM_DATE, TO_DATE, PRICE, DESCRIPTION)]

        when:
        def result = travelService.getAllTravelsByCity(CITY)

        then:
        1 * travelRepository.findAllByCity(CITY) >> travel

        and:
        result == travel

        and:
        0 * _._
    }

    def "Delete all travels by city"() {
        when:
        travelService.deleteAllTravelsByCity(CITY)

        then:
        1 * travelRepository.deleteByCity(CITY)

        and:
        0 * _._
    }

    def "Update travel"() {
        setup:
        def travel = new Travel(1L, NAME, CITY, FROM_DATE, TO_DATE, PRICE, DESCRIPTION)

        when:
        def result = travelService.updateTravel(NAME, new Travel(1L, NAME, CITY, FROM_DATE, TO_DATE, 1600, DESCRIPTION))

        then:
        1 * travelRepository.findByName(NAME) >> travel

        and:
        1 * travelRepository.save(!null as Travel) >> {
            Travel travel1 ->
                assert travel1.getPrice() == 1600
                return new Travel(1L, NAME, CITY, FROM_DATE, TO_DATE, 1600, DESCRIPTION)
        }

        and:
        result == new Travel(1L, NAME, CITY, FROM_DATE, TO_DATE, 1600, DESCRIPTION)
    }
}
