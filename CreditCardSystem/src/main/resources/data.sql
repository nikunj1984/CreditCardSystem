SET REFERENTIAL_INTEGRITY FALSE;
TRUNCATE TABLE credit_card;
SET REFERENTIAL_INTEGRITY TRUE;
ALTER TABLE credit_card ALTER COLUMN id RESTART WITH 1;

INSERT INTO credit_card(id, name, card_number, card_limit, balance) VALUES(1, 'Joe', '1100111122222222', 700, 100.0);
INSERT INTO credit_card(id, name, card_number, card_limit, balance) VALUES(2, 'Adam', '2222222233334444', 400, -80.0);
