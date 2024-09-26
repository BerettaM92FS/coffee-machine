CREATE TABLE IF NOT EXISTS public.orders
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    drinks_id integer NOT NULL,
    date timestamp without time zone NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT orders_to_drink_key FOREIGN KEY (drinks_id)
        REFERENCES public.drinks (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE public.orders
    OWNER to postgres;

INSERT INTO public.orders (drinks_id, date) VALUES (1, '2024-09-25 22:10:10');
INSERT INTO public.orders (drinks_id, date) VALUES (1, '2024-09-25 22:11:10');
INSERT INTO public.orders (drinks_id, date) VALUES (1, '2024-09-25 22:12:10');
INSERT INTO public.orders (drinks_id, date) VALUES (2, '2024-09-25 22:13:10');
INSERT INTO public.orders (drinks_id, date) VALUES (2, '2024-09-25 22:14:10');
INSERT INTO public.orders (drinks_id, date) VALUES (3, '2024-09-25 22:15:10');
INSERT INTO public.orders (drinks_id, date) VALUES (3, '2024-09-25 22:16:10');
INSERT INTO public.orders (drinks_id, date) VALUES (3, '2024-09-25 22:17:10');
INSERT INTO public.orders (drinks_id, date) VALUES (3, '2024-09-25 22:18:10');

