INSERT INTO public.books (id, name, author, reader_id)
VALUES  (1, 'Автостопом по галактике', 'Дуглас Адамс', null),
        (2, 'Гарри Поттер и Кубок огня', 'Джоан Роулинг', null),
        (3, 'Гордость и предубеждение', 'Джейн Остин', null),
        (4, 'Тёмные начала', 'Филип Пулман', null);
		
		
INSERT INTO public.readers (id, email, telegram, book_id, password, role, name)
VALUES  (1, 'csc', '11111111112', null, '$2y$10$g.YlInuZ5SNsYqEPe0EpNeIFEpL084zHjlgOMennetW1Grz8XNqVq', 'USER', 'Rebecca Bryant'),
        (2, 'sdddess1111', '11111112211', null, '$2y$10$g.YlInuZ5SNsYqEPe0EpNeIFEpL084zHjlgOMennetW1Grz8XNqVq', 'USER', 'Jeff Cross'),
        (4, 'hewaba_caxe13@mail.ru', '12392435365', null, '$2y$10$g.YlInuZ5SNsYqEPe0EpNeIFEpL084zHjlgOMennetW1Grz8XNqVq', 'USER', 'Robert Price'),
        (5, 'jejoxa-xacu22@yandex.ru', '12392435378', null, '$2y$10$g.YlInuZ5SNsYqEPe0EpNeIFEpL084zHjlgOMennetW1Grz8XNqVq', 'USER', 'user'),
        (6, 'soxu_zanocu25@yahoo.com', '1739275216', null, '$2y$10$WvHnDandLRJHGJ2dP56aBOOG2wwShVkRGwTIulJIfAc6suOeOVwom', 'ADMIN', 'admin'),
        (7, 'sutebex_icu57@yahoo.com', '12392435378', null, '$2y$10$g.YlInuZ5SNsYqEPe0EpNeIFEpL084zHjlgOMennetW1Grz8XNqVq', 'USER', 'Jessica Miller'),
        (3, 'wup-efaruxo94@yahoo.com', '1739275269', null, '$2y$10$WvHnDandLRJHGJ2dP56aBOOG2wwShVkRGwTIulJIfAc6suOeOVwom', 'ADMIN', 'Joyce Reyes'),
        (11, 'asdsdf25', '1234567890', null, 'dswfew3', 'USER', 'asfddf4');
