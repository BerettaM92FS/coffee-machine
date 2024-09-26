CREATE TABLE IF NOT EXISTS public.stock_ingredients
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    coffee integer NOT NULL,
    water integer NOT NULL,
    milk integer NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.stock_ingredients
    OWNER to postgres;

INSERT INTO public.stock_ingredients(coffee, water, milk) VALUES (1000, 1500, 1700);