insert into users (id, name)
values ('eb0a53e4-3f59-4587-b398-a4c9762555af', 'Max Mustermann'),
       ('185ff565-67f2-45b9-8625-9a8423a1ad7b', 'Maria Müller'),
       ('49f50916-1bf5-4eba-8a4e-7f51c2d64ae8', 'Hans Meier'),
       ('cafbc418-1daa-4043-bce8-e91390781811', 'Clara Schmidt');

insert into stations(id, name, longitude, latitude, maximum_bike_capacity)
values ('02cafc8b-4feb-4c91-b6ad-8f0d8b35b429', 'Eschborn One100', 50.134984, 8.572595, 30),
       ('0c7684d8-d791-466a-a9ff-a9eee2b92ff6', 'Frankfurt Solmsstraße', 50.118512, 8.631344, 15),
       ('ea5da5ac-1163-41c9-83ae-e9665284c794', 'Frankfurt OReillys', 50.106679, 8.665547,25);

insert into bikes (id, day_of_purchase, station_id, brand, electrified, type)
values ('3544bc21-79bc-49b0-904c-4a1a5b7b4fe1', '2023-01-01', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6', 'BestBike', false, 0),
       ('bc5f115a-afa5-47dd-a633-d501de45e333', '2023-01-01', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6', 'BestBike', false, 1),
       ('fe8c24a5-32ff-42e9-8247-3f3033914b30', '2023-01-01', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6', 'NextBike', true, 1),
       ('c8d3f791-97fb-479c-8930-736cb80fb3bd', '2023-01-01', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6', 'NextBike', true, 1),
       ('268e5c7f-39f7-484d-9e84-9d9a988fea5a', '2023-01-01', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6', 'NextBike', false, 2),
       ('988e317c-defe-4aa3-ad56-8c37f6fe01d1', '2024-04-01', '02cafc8b-4feb-4c91-b6ad-8f0d8b35b429', 'NextBike', false, 0),
       ('c93ffaa7-7cdd-49b4-893f-4f7ff6319ddf', '2024-04-01', '02cafc8b-4feb-4c91-b6ad-8f0d8b35b429', 'NextBike', false, 0),
       ('21da51d3-82f2-4df8-978f-de0ac59656fb', '2024-04-01', '02cafc8b-4feb-4c91-b6ad-8f0d8b35b429', 'NextBike', false, 0),
       ('69ad112f-cf98-4b08-9dfd-89e69c430c9a', '2024-04-01', '02cafc8b-4feb-4c91-b6ad-8f0d8b35b429', 'NextBike', false, 1),
       ('099e4fd9-f552-4b59-a9f7-5ba1de16b19a', '2024-04-01', '02cafc8b-4feb-4c91-b6ad-8f0d8b35b429', 'NextBike', false, 1),
       ('fb98cc55-2557-4825-a559-c094a60244e1', '2024-04-01', '02cafc8b-4feb-4c91-b6ad-8f0d8b35b429', 'BestBike', true, 1),
       ('95f42647-7f0b-46f1-b30a-3f42d8608bf1', '2024-02-29', '02cafc8b-4feb-4c91-b6ad-8f0d8b35b429', 'BestBike', true, 1),
       ('ce3beab3-8960-4393-ae90-c1c5d9f9890f', '2024-02-29', '02cafc8b-4feb-4c91-b6ad-8f0d8b35b429', 'BestBike', true, 1),
       ('b38ed787-81b4-4848-a800-30b4291a7e40', '2024-02-29', '02cafc8b-4feb-4c91-b6ad-8f0d8b35b429', 'BestBike', false, 2),
       ('2e4ea18c-4cc3-4596-9135-4863f5c755c6', '2024-02-29', '02cafc8b-4feb-4c91-b6ad-8f0d8b35b429', 'BestBike', false, 2),
       ('aba84114-2eb6-4701-99de-51355bd08cc4', '2024-02-29', 'ea5da5ac-1163-41c9-83ae-e9665284c794', 'BestBike', false, 0),
       ('04499c92-1241-4631-9880-4c4902f20c8c', '2024-02-29', 'ea5da5ac-1163-41c9-83ae-e9665284c794', 'BestBike', true, 0),
       ('4c521dbd-9fe9-409a-9887-4a64083e2324', '2024-02-29', 'ea5da5ac-1163-41c9-83ae-e9665284c794', 'BestBike', true, 0),
       ('6edd6bb8-cc19-4404-83a5-0991225eed76', '2024-02-29', 'ea5da5ac-1163-41c9-83ae-e9665284c794', 'NextBike', true, 2),
       ('b560a78a-fc50-42c4-b036-b9f2fbdae3fb', '2024-02-29', 'ea5da5ac-1163-41c9-83ae-e9665284c794', 'NextBike', true, 2);

-- insert into rentals(id, user_id, bike_id, start, start_station_id, end, end_station_id)
-- values ('1704b9fe-855e-4bd2-be6d-ce0898328e5c', '49f50916-1bf5-4eba-8a4e-7f51c2d64ae8', '3544bc21-79bc-49b0-904c-4a1a5b7b4fe1', '2023-01-01 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6', '2023-01-02 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6'),
--        ('1b1061df-7683-400a-90fb-19560c270c31', '49f50916-1bf5-4eba-8a4e-7f51c2d64ae8', 'bc5f115a-afa5-47dd-a633-d501de45e333', '2023-02-01 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6', '2023-02-02 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6'),
--        ('8a16eb35-69e0-45b4-a42d-3bb001321333', '49f50916-1bf5-4eba-8a4e-7f51c2d64ae8', 'fe8c24a5-32ff-42e9-8247-3f3033914b30', '2023-03-01 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6', '2023-03-02 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6'),
--        ('db87d7a4-8dd8-4340-a48c-7fa44af10e3f', 'eb0a53e4-3f59-4587-b398-a4c9762555af', 'c8d3f791-97fb-479c-8930-736cb80fb3bd', '2023-04-01 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6', '2023-04-02 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6'),
--        ('9866b760-f5ba-461f-b7c4-677be17c8480', 'eb0a53e4-3f59-4587-b398-a4c9762555af', '268e5c7f-39f7-484d-9e84-9d9a988fea5a', '2023-05-01 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6', '2023-05-02 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6'),
--        ('2135a9c3-c28f-48cb-9284-70c0e464a16c', 'eb0a53e4-3f59-4587-b398-a4c9762555af', '988e317c-defe-4aa3-ad56-8c37f6fe01d1', '2023-06-01 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6', '2023-06-02 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6'),
--        ('9057b0bf-0494-4867-9dd5-c37893d71a71', 'eb0a53e4-3f59-4587-b398-a4c9762555af', 'c93ffaa7-7cdd-49b4-893f-4f7ff6319ddf', '2023-07-01 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6', '2023-07-02 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6'),
--        ('d321b18e-f98c-448a-a9c2-e33b91ee2ac0', 'eb0a53e4-3f59-4587-b398-a4c9762555af', '21da51d3-82f2-4df8-978f-de0ac59656fb', '2023-08-01 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6', '2023-08-02 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6'),
--        ('cf8dc5dd-4b91-4c1a-970f-984ccaf7980e', '185ff565-67f2-45b9-8625-9a8423a1ad7b', '69ad112f-cf98-4b08-9dfd-89e69c430c9a', '2023-09-01 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6', '2023-09-02 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6'),
--        ('913168fc-174d-4ebe-9f95-98712f8b17bd', '185ff565-67f2-45b9-8625-9a8423a1ad7b', '099e4fd9-f552-4b59-a9f7-5ba1de16b19a', '2023-10-01 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6', '2023-10-02 12:34:56', '0c7684d8-d791-466a-a9ff-a9eee2b92ff6');