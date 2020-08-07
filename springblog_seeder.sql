USE springblog;

TRUNCATE TABLE posts;
DELETE FROM users WHERE id > 0;

INSERT INTO users (id, email, password, username) VALUES
(1,'greenthumb@plants.com','myfakepassword','GreenThumb1'),
(2,'jondg@yahoo.com','fakenumber2','jondgraham'),
(3,'sexpistol@gmail.com','fake14u','godsavethequeen'),
(4,'killsmany@plants.com','ez2forget','trying2hard');

INSERT INTO posts (id, user_id, title, body) VALUES
(1,1,'African Liverseed Grass','Poaceae / Urochloa mosambicensis (Hack.) Dandy'),
(2,1,'Vanillaleaf','Asteraceae / Carphephorus odoratissimus (J.F. Gmel.) Herb.'),
(3,4,'Western Catchfly','Caryophyllaceae / Silene occidentalis S. Watson ssp. longistipitata C.L. Hitchc. & Maguire'),
(4,3,'Rayless Shaggy Fleabane','Asteraceae / Erigeron aphanactis (A. Gray) Greene var. aphanactis'),
(5,1,'Streambank Rabbitsfoot Grass','Poaceae / Polypogon elongatus Kunth'),
(6,2,'Tall Poppymallow','Malvaceae / Callirhoe leiocarpa R.F. Martin'),
(7,2,'Northern Lecidea Lichen','Lecideaceae / Lecidea polaris Lynge'),
(8,1,'Cupped Monolopia','Asteraceae / Monolopia major DC.'),
(9,3,'Hairy Goldenrod','Asteraceae / Solidago hispida Muhl. ex Willd. var. hispida'),
(10,4,'Stahl\'s Stopper','Myrtaceae / Eugenia stahlii (Kiaersk.) Krug & Urb.'),
(11,3,'Alabama Supplejack','Rhamnaceae / Berchemia scandens (Hill) K. Koch'),
(12,2,'Yellow Sunnybell','Liliaceae / Schoenolirion croceum (Michx.) Alph. Wood'),
(13,1,'Sitka Willow','Salicaceae / Salix sitchensis Sanson ex Bong.'),
(14,4,'Nettleleaf Giant Hyssop','Lamiaceae / Agastache urticifolia (Benth.) Kuntze'),
(15,4,'Zornia','Fabaceae / Zornia J.F. Gmel.'),
(16,2,'Acrocordia Lichen','Monoblastiaceae / Acrocordia gemmata (Ach.) A. Massal.'),
(17,1,'Mountain Tail-leaf','Asteraceae / Pericome caudata A. Gray'),
(18,1,'Waterlily','Nymphaeaceae / Nymphaea ×thiona Ward'),
(19,4,'Lyall\'s Beardtongue','Scrophulariaceae / Penstemon lyallii (A. Gray) A. Gray'),
(20,3,'Douglas\' Spineflower','Polygonaceae / Chorizanthe douglasii Benth.'),
(21,1,'Sticky Blue Eyed Mary','Scrophulariaceae / Collinsia rattanii A. Gray ssp. rattanii'),
(22,3,'Phyllostegia','Lamiaceae / Phyllostegia ×yamaguchii Hosaka & O. Deg. (pro sp.)'),
(23,1,'Climbing Cactus','Cactaceae / Epiphyllum hookeri (Link & Otto) Haw.'),
(24,4,'Swampforest Clermontia','Campanulaceae / Clermontia waimeae Rock'),
(25,4,'Berteron\'s Sandmat','Euphorbiaceae / Chamaesyce berteriana (Balbis ex Spreng.) Millsp.');