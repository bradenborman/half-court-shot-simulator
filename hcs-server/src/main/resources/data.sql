DROP TABLE IF EXISTS game_history;

CREATE TABLE game_history (
  score_id INT AUTO_INCREMENT  PRIMARY KEY,
  starting_position VARCHAR(250) NOT NULL,
  shots_to_finish INT NOT NULL
);

INSERT INTO game_history (starting_position, shots_to_finish)
VALUES
  ('HALF_COURT', 50),
  ('LAYUP', 500),
  ('HALF_COURT', 48),
  ('LAYUP', 200);