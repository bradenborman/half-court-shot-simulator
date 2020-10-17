package borman.halfcourtshotsimulator.services

import borman.halfcourtshotsimulator.exceptions.InvalidStartingLocation
import borman.halfcourtshotsimulator.models.ShotLocation
import spock.lang.Specification
import spock.lang.Unroll

class SimulationServiceTest extends Specification {

    @Unroll
    def "simulate Test"() {
        setup:
        SimulationService simulationService = new SimulationService()
        List<ShotLocation> shotsToTake = ShotLocation.getShotSequence(startingSpot.name())

        when:
        simulationService.simulate(shotsToTake)

        then:
        noExceptionThrown()

        where:
        startingSpot << [
                ShotLocation.HALF_COURT, ShotLocation.LAYUP
        ]
    }

    @Unroll
    def "simulate Invalid Starting Location Test"() {
        when:
        List<ShotLocation> shotsToTake = ShotLocation.getShotSequence(startingSpot.name())

        then:
        thrown(InvalidStartingLocation.class)

        where:
        startingSpot << [
                ShotLocation.THREE_POINTER, ShotLocation.FREE_THROW
        ]
    }

}