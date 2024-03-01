DROP TABLE IF EXISTS BACKPACK_DATA;
CREATE TABLE BACKPACK_DATA(
                              id int PRIMARY KEY AUTO_INCREMENT,
                              name VARCHAR(250),
                              quantity INT,
                              kilometers INT,
                              season JSON
);

INSERT INTO BACKPACK_DATA( name, quantity, kilometers, season ) VALUES ('backpack', 1, 1, '["Spring", "Summer", "Autumn", "Winter"]');
INSERT INTO BACKPACK_DATA( name, quantity, kilometers, season ) VALUES ('pair of boots', 1, 1, '["Spring", "Summer", "Autumn", "Winter"]');
INSERT INTO BACKPACK_DATA( name, quantity, kilometers, season ) VALUES ('pair of boots', 2, 50, '["Spring", "Summer", "Autumn", "Winter"]');
INSERT INTO BACKPACK_DATA( name, quantity, kilometers, season ) VALUES ('sunscreen', 1, 20, '["Summer"]');
INSERT INTO BACKPACK_DATA( name, quantity, kilometers, season ) VALUES ('umbrella', 1, 15, '["Spring", "Autumn"]');
INSERT INTO BACKPACK_DATA( name, quantity, kilometers, season ) VALUES ('gloves', 1, 1, '["Winter"]');
INSERT INTO BACKPACK_DATA( name, quantity, kilometers, season ) VALUES ('snacks', 3, 15, '["Spring", "Summer", "Autumn", "Winter"]');
INSERT INTO BACKPACK_DATA( name, quantity, kilometers, season ) VALUES ('snacks', 6, 30, '["Spring", "Summer", "Autumn", "Winter"]');
INSERT INTO BACKPACK_DATA( name, quantity, kilometers, season ) VALUES ('raincoat', 1, 50, '["Spring", "Autumn"]');
INSERT INTO BACKPACK_DATA( name, quantity, kilometers, season ) VALUES ('gloves', 2, 75, '["Winter"]');
