CREATE TABLE IF NOT EXISTS public.drinks
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    name character varying(25) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.drinks
    OWNER to postgres;

INSERT INTO public.drinks (name) VALUES ('Эспрессо');
INSERT INTO public.drinks (name) VALUES ('Американо');
INSERT INTO public.drinks (name) VALUES ('Капучино');