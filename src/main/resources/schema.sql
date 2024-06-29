CREATE TABLE IF NOT EXISTS moneypots (
    id SERIAL PRIMARY KEY,
    client_id BIGINT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    number_of_transactions INT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);