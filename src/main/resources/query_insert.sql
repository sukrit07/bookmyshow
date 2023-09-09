INSERT INTO public.actor(created_at, id, modified_at, name)
VALUES ('2023-07-08', 1, '2023-07-19', 'Soumitro Chattopadhay');

INSERT INTO public.actor(created_at, id, modified_at, name)
VALUES ('2023-07-08', 2, '2023-07-19', 'Shahrukh Khan');

INSERT INTO public.actor(created_at, id, modified_at, name)
VALUES ('2023-07-08', 3, '2023-07-19', 'Uttam Kumar');

INSERT INTO public.actor(created_at, id, modified_at, name)
VALUES ('2023-07-08', 4, '2023-07-19', 'Alia Bhatt');

INSERT INTO public.city(created_at, id, modified_at, name, state)
VALUES ('2023-07-08', 1, '2023-07-08', 'Kolkata', 'West Bengal');

INSERT INTO public.city(created_at, id, modified_at, name, state)
VALUES ('2023-07-08', 3, '2023-07-08', 'Chennai', 'TamilNadu');

INSERT INTO public.city(created_at, id, modified_at, name, state)
VALUES ('2023-07-08', 2, '2023-07-08', 'Bengaluru', 'Karnataka');

INSERT INTO public.auditorium(created_at, id, modified_at, name)
VALUES ('2023-07-08', 1, '2023-07-19', 'AUDI 1');

INSERT INTO public.auditorium_auditorium_features(auditorium_id, auditorium_features)
VALUES (1, 'IMAX');

INSERT INTO public.seat(col, "row", seat_status, seat_type, created_at, id, modified_at, name)
VALUES (1, 1, 1, 1, '2023-07-08', 1, '2023-07-08', 'A1');

INSERT INTO public.auditorium_seats(auditorium_id, seats_id)
VALUES (1, 1);



