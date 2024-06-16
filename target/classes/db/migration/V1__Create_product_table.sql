CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS public.products
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    name CHARACTER VARYING(255) NOT NULL,
    category CHARACTER VARYING(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    quantity INTEGER NOT NULL,
    creation_date TIMESTAMP NOT NULL
);
