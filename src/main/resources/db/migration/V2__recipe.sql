CREATE TABLE IF NOT EXISTS public.recipe
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    drinks_id integer NOT NULL,
    coffee integer NOT NULL,
    water integer NOT NULL,
    milk integer NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT recipe_to_drink_key FOREIGN KEY (drinks_id)
        REFERENCES public.drinks (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE public.recipe
    OWNER to postgres;

INSERT INTO public.recipe (drinks_id, coffee, water, milk) VALUES (1, 8, 32, 0);
INSERT INTO public.recipe (drinks_id, coffee, water, milk) VALUES (2, 8, 45, 0);
INSERT INTO public.recipe (drinks_id, coffee, water, milk) VALUES (1, 9, 0, 31);