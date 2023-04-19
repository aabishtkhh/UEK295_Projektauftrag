-- users
INSERT INTO online_book_store_users (users_id, name, password)
VALUES (1, 'user', 'user01_uek295'),
       (2, 'user2', 'user02_uek295') ON CONFLICT DO NOTHING;

-- roles
INSERT INTO online_book_store_roles(id_role, name)
VALUES (1, 'ADMIN'),
       (2, 'USER') ON CONFLICT DO NOTHING;

-- authorities
INSERT INTO online_book_store_authorities(id_auth, name)
VALUES (1, 'GET'),
       (2, 'POST'),
       (3, 'PUT'),
       (4, 'DELETE') ON CONFLICT DO NOTHING;

-- assign roles to users
INSERT INTO online_book_store_users_roles (user_id, id_role)
VALUES (1, 1),
       (2, 2) ON CONFLICT DO NOTHING;

-- assign authorities to roles
INSERT INTO online_book_store_roles_authorities(id_role, id_auth)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),

       (2, 1),
       (2, 2),
       (2, 3),
       (2,4)
ON CONFLICT DO NOTHING;






