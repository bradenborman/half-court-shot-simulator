"# half-court-shot-simulator" 


Method that wont start over on miss:
<code:java>
 public void startSequence(ShotLocation startingPoint) {
        logger.info("Starting shot process from: {}", startingPoint.name());
        List<ShotLocation> shotsToAttempt = ShotLocation.getShotSequence(startingPoint);
        shotsToAttempt.forEach(spotToShot -> {
            boolean wasMade = false;
            int attempts = 0;
            do {
                attempts++;
                wasMade = spotToShot.attemptShot();
            } while (!wasMade);
            logger.info("Shot was made from {} after {}", spotToShot.name(), attempts);
        });

    }
</code>