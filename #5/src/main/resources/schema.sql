DROP TABLE IF EXISTS POST_COMMENT;
DROP TABLE IF EXISTS POST;

CREATE TABLE POST (
                      ID       BIGINT      NOT NULL,
                      TITLE    VARCHAR(1000) NOT NULL,
                      POST_DATE DATE       NOT NULL,
                      PRIMARY KEY (ID)
) ENGINE=InnoDB;

CREATE TABLE POST_COMMENT (
                              ID           BIGINT       NOT NULL,
                              REVIEW       VARCHAR(1000) DEFAULT NULL,
                              COMMENT_DATE DATE         NOT NULL,
                              POST_ID      BIGINT       DEFAULT NULL,
                              PRIMARY KEY (ID),
                              CONSTRAINT FK_POST_COMMENT_POST_ID
                                  FOREIGN KEY (POST_ID) REFERENCES POST(ID)
                                      ON UPDATE CASCADE
                                      ON DELETE RESTRICT
) ENGINE=InnoDB;
