INSERT INTO public.books (name, author, reader_id)
VALUES  ('Автостопом по галактике', 'Дуглас Адамс', null),
        ('Гарри Поттер и Кубок огня', 'Джоан Роулинг', null),
        ('Гордость и предубеждение', 'Джейн Остин', null),
        ('Тёмные начала', 'Филип Пулман', null);
		
		
INSERT INTO public.readers (email, telegram, book_id, password, role, name)
VALUES  ('csc', '11111111112', null, '$2y$10$g.YlInuZ5SNsYqEPe0EpNeIFEpL084zHjlgOMennetW1Grz8XNqVq', 'USER', 'Rebecca Bryant'),
        ('sdddess1111', '11111112211', null, '$2y$10$g.YlInuZ5SNsYqEPe0EpNeIFEpL084zHjlgOMennetW1Grz8XNqVq', 'USER', 'Jeff Cross'),
        ('hewaba_caxe13@mail.ru', '12392435365', null, '$2y$10$g.YlInuZ5SNsYqEPe0EpNeIFEpL084zHjlgOMennetW1Grz8XNqVq', 'USER', 'Robert Price'),
        ('jejoxa-xacu22@yandex.ru', '12392435378', null, '$2y$10$g.YlInuZ5SNsYqEPe0EpNeIFEpL084zHjlgOMennetW1Grz8XNqVq', 'USER', 'user'),
        ('soxu_zanocu25@yahoo.com', '1739275216', null, '$2y$10$WvHnDandLRJHGJ2dP56aBOOG2wwShVkRGwTIulJIfAc6suOeOVwom', 'ADMIN', 'admin'),
        ('sutebex_icu57@yahoo.com', '12392435378', null, '$2y$10$g.YlInuZ5SNsYqEPe0EpNeIFEpL084zHjlgOMennetW1Grz8XNqVq', 'USER', 'Jessica Miller'),
        ('wup-efaruxo94@yahoo.com', '1739275269', null, '$2y$10$WvHnDandLRJHGJ2dP56aBOOG2wwShVkRGwTIulJIfAc6suOeOVwom', 'ADMIN', 'Joyce Reyes'),
        ('wuk-ayacohu44@aol.com', '1234567890', null, '$2y$10$g.YlInuZ5SNsYqEPe0EpNeIFEpL084zHjlgOMennetW1Grz8XNqVq', 'USER', 'Billie Barrett');
