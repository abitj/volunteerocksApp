DROP TABLE IF EXISTS TBL_VOLUNTEERS;
DROP TABLE IF EXISTS TBL_OPPORTUNITIES;
 
CREATE TABLE TBL_VOLUNTEERS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  vol_full_name VARCHAR(250) NOT NULL,
  vol_location VARCHAR(250) NOT NULL,
  vol_email VARCHAR(250) DEFAULT NULL
);

CREATE TABLE TBL_OPPORTUNITIES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  opp_description VARCHAR(250) NOT NULL,
  opp_location VARCHAR(250) NOT NULL,
  opp_number_needed INT
);