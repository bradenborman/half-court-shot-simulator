package borman.halfcourtshotsimulator.models

import spock.lang.Specification

class ShotLocationTest extends Specification {

    def "attemptShot Test"() {
        when:
        println "Attempting shots from: " + shotLocation.name()
        for (int i = 0; i < 20; i++) {
            boolean attemptedShotStatus = shotLocation.attemptShot()
            println "\tShot was made: " + attemptedShotStatus
        }

        then:
        noExceptionThrown()

        where:
        shotLocation << [
                ShotLocation.HALF_COURT, ShotLocation.THREE_POINTER, ShotLocation.FREE_THROW, ShotLocation.LAYUP
        ]

    }

}