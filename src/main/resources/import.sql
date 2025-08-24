-- Programação de Segunda a Sexta
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Sertão Repente e Viola', 'Guilherme Calixto', 'Segunda a Sábado', '05:00:00', '06:00:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Bom Dia Alegria', 'Teixeira Filho', 'Segunda a Sexta', '06:00:00', '07:30:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Jornal da Dom Bosco', 'Institucional', 'Segunda a Sexta', '07:30:00', '08:00:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Manhã da Cultura', 'Vanderley Paulino', 'Segunda a Sexta', '08:00:00', '10:00:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Experiência de Deus', 'Padre Reginaldo Manzotti', 'Segunda a Sábado', '10:00:00', '11:00:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Esporte é Cultura Primeira Edição', 'Teixeira Filho e Equipe Esportiva Everton Lopes', 'Segunda a Sexta', '11:00:00', '11:30:00');
-- Jornal da Cultura de Segunda a Quinta (horário normal)
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Jornal da Cultura', 'Jarbas Santos', 'Segunda a Quinta', '11:30:00', '13:00:00');

-- Jornal da Cultura na Sexta (horário mais curto, após o SINDSEP)
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Jornal da Cultura', 'Jarbas Santos', 'Sexta-Feira', '12:00:00', '13:00:00');

INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Especial Musical', 'Programação Musical', 'Segunda a Sexta', '13:00:00', '14:00:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Revista no Rádio', 'Genivaldo Ferreira', 'Segunda a Sexta', '14:00:00', '16:00:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Programa Tempo de Paz', 'Padre João Carlos', 'Segunda a Sexta', '16:00:00', '17:00:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Missa FM Dom Bosco', 'Institucional', 'Segunda a Sexta', '17:00:00', '17:45:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Vatican News', 'A Rádio do Papa', 'Segunda a Sexta', '17:45:00', '18:00:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Santo Terço', 'Institucional', 'Segunda a Sexta', '18:00:00', '18:30:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Esporte é Cultura Segunda Edição', 'Jonas Lopes e Equipe Esportiva Everton Lopes', 'Segunda a Sexta', '18:30:00', '19:00:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('A Voz do Brasil', 'Governo Federal', 'Segunda a Sexta', '19:00:00', '20:00:00');

-- Programa específico da Sexta-Feira (exceção à regra)
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('SINDSEP Em Ação', 'Luisa Sousa', 'Sexta-Feira', '11:30:00', '12:00:00');

-- Programação de Sábado
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Transmissão da Santa Missa', 'Comunidade Boa Semente', 'Sábado', '06:00:00', '07:00:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Bodega Ecológica', 'Eronilton Buriti', 'Sábado', '07:00:00', '07:30:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Sindicato dos Trabalhadores Rurais', 'Institucional', 'Sábado', '07:30:00', '08:00:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Hora da Caridade', 'Vicentinos', 'Sábado', '08:00:00', '09:00:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('A Voz da Diocese', 'Williame Marques e Padre Pablo', 'Sábado', '09:00:00', '10:00:00');

-- Programação de Domingo
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('O Rei do Baião', 'Luciano Silva', 'Domingo', '12:00:00', '15:00:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('Tarde Esportiva', 'Equipe Everton Lopes', 'Domingo', '15:00:00', '19:00:00');
INSERT INTO tb_program (name, presenter, days_of_week, start_time, end_time) VALUES ('A Santa Missa da Catedral', 'Paróquia da Catedral', 'Domingo', '19:00:00', '20:00:00');