drop table if exists JovemAlergia;
drop table if exists JovemResponsavel;
drop table if exists RequisitoCumpridoEspecialidade;
drop table if exists RequisitoCumpridoInsignia;
drop table if exists RequisitoCumpridoProgressao;
drop table if exists Participacao;
drop table if exists Jovem;
drop table if exists Responsavel;
drop table if exists RequisitoEspecialidade;
drop table if exists RequisitoProgressao;
drop table if exists RequisitoInsignia;
drop table if exists Especialidade;
drop table if exists Insignia;
drop table if exists Progressao;
drop table if exists Atividade;
drop table if exists AreaDeConhecimento;
drop table if exists Endereco;
drop table if exists Alergia;

--FAZER CASES
    -- not null
-- rever tabelas requisito e requisito|Cumprido a quetao de ofreign key e primary jey, acho que confundi

create table Alergia(
                        idAlergia integer primary key auto_increment,
                        nome varchar(40)
) ENGINE=InnoDB;


create table AreaDeConhecimento(
                        idAreaConhecimento integer primary key auto_increment,
                        nome varchar(40)
)ENGINE=InnoDB;

create table Atividade(
                        idAtividade integer primary key auto_increment,
                        nome varchar(40)
)ENGINE=InnoDB;

create table Endereco(
                         idEndereco integer primary key auto_increment,
                         rua varchar(40),
                         numero integer,
                         cep varchar(20),
                         cidade varchar(30),
                         estado varchar(30)
)ENGINE=InnoDB;

create table Especialidade(
                        idEspecialidade integer primary key auto_increment,
                        nome varchar(60),
                        numRequisitos integer,
                        idAreaConhecimento integer,
                        constraint foreign key (idAreaConhecimento) references AreaDeConhecimento (idAreaConhecimento)

)ENGINE=InnoDB;

create table Insignia(
                         idInsignia integer primary key auto_increment,
                         nome varchar(60),
                         numRequisitos integer
)ENGINE=InnoDB;


create table Progressao(
                           idProgressao integer primary key auto_increment,
                           nome varchar(60),
                           numRequisitos integer
)ENGINE=InnoDB;

create table Responsavel(

                            idResponsavel integer primary key auto_increment,
                            nome varchar(30),
                            telefone varchar(20),
                            email varchar(60),
                            idEndereco integer,
                            constraint foreign key (idEndereco) references Endereco (idEndereco)
)ENGINE=InnoDB;


create table Jovem(
                      idJovem integer primary key auto_increment,
                      nome varchar(60),
                      dataNascimento date,
                      telefone varchar(20),
                      tipoSanguineo varchar(3),
                      email varchar(60),
                      idEndereco integer,
                      constraint foreign key (idEndereco) references Endereco (idEndereco)

)ENGINE=InnoDB;


create table RequisitoEspecialidade(
                                       idRequisitoEspecialidade integer primary key auto_increment,
                                       idEspecialidade integer,
                                       descricao varchar(200),
                                       constraint foreign key (idEspecialidade) references Especialidade (idEspecialidade)

)ENGINE=InnoDB;


create table RequisitoProgressao(

                                    idRequisitoProgressao integer primary key auto_increment,
                                    idProgressao integer,
                                    descricao varchar(200),
                                    constraint foreign key (idProgressao) references Progressao (idProgressao)
)ENGINE=InnoDB;


create table RequisitoInsignia(

                                  idRequisitoInsignia integer primary key auto_increment,
                                  idInsignia integer,
                                  descricao varchar(200),
                                  constraint foreign key (idInsignia) references Insignia (idInsignia)
)ENGINE=InnoDB;


create table RequisitoCumpridoEspecialidade(

                                               idJovem integer,
                                               idRequisitoEspecialidade integer,
                                               primary key (idJovem, idRequisitoEspecialidade),
                                               data date,
                                               constraint foreign key (idJovem) references Jovem (idJovem),
                                               constraint foreign key (idRequisitoEspecialidade) references RequisitoEspecialidade(idRequisitoEspecialidade)

)ENGINE=InnoDB;


create table RequisitoCumpridoInsignia(

                                          idJovem integer,
                                          idRequisitoInsignia integer,
                                          primary key (idJovem, idRequisitoInsignia),
                                          data date,
                                          constraint foreign key (idJovem) references Jovem (idJovem),
                                          constraint foreign key (idRequisitoInsignia) references RequisitoInsignia (idRequisitoInsignia)

)ENGINE=InnoDB;

create table RequisitoCumpridoProgressao(

                                            idJovem integer,
                                            idRequisitoProgressao integer,
                                            primary key (idJovem, idRequisitoProgressao),
                                            data date,
                                            constraint foreign key (idJovem) references Jovem (idJovem),
                                            constraint foreign key (idRequisitoProgressao) references RequisitoProgressao(idRequisitoProgressao)

)ENGINE=InnoDB;


create table Participacao(
                        idJovem integer,
                        idAtividade integer,
                        primary key (idJovem, idAtividade),
                        data date,
                        constraint foreign key (idJovem) references Jovem (idJovem),
                        constraint foreign key (idAtividade) references Atividade (idAtividade)

)ENGINE=InnoDB;


create table JovemAlergia (
                        idJovem integer,
                        idAlergia integer,
                        primary key (idJovem, idAlergia),
                        constraint foreign key (idJovem) references Jovem(idJovem),
                        constraint foreign key (idAlergia) references Alergia(idAlergia)
)ENGINE=InnoDB;

create table JovemResponsavel (
                            idJovem integer,
                            idResponsavel integer,
                            primary key (idJovem, idResponsavel),
                            constraint foreign key (idJovem) references Jovem(idJovem),
                            constraint foreign key (idResponsavel) references Responsavel(idResponsavel)
)ENGINE=InnoDB;

-- Povoamento

insert into AreaDeConhecimento (nome) values
                  ('Ciência e Tecnologia'),
                  ('Cultura'),
                  ('Desportos'),
                  ('Habilidades Escoteiras'),
                  ('Serviços');

insert into Endereco (rua, numero, cep, cidade, estado) values
                    ('Rua das Acácias', 123, '88000-001', 'Florianópolis', 'SC'),
                    ('Av. Brasil', 456, '88000-002', 'São José', 'SC'),
                    ('Rua das Palmeiras', 78, '88000-003', 'Palhoça', 'SC'),
                    ('Rua Ipê Roxo', 99, '88000-004', 'Florianópolis', 'SC'),
                    ('Travessa dos Pinheiros', 101, '88000-005', 'Biguaçu', 'SC'),
                    ('Rua Hortênsias', 222, '88000-006', 'São José', 'SC');

insert into Alergia (nome) values
                   ('Amendoim'),
                   ('Lactose'),
                   ('Pólen'),
                   ('Glúten'),
                   ('Camarão');

insert into Atividade (nome) values
                 ('Acampamento'),
                 ('Palestra sobre primeiros socorros'),
                 ('Corrida na trilha'),
                 ('Oficina de robótica');

insert into Especialidade (nome, numRequisitos, idAreaConhecimento) values
                ('Programação Básica', 5, 1),       -- Ciência e Tecnologia
                ('Teatro Infantil', 4, 2),          -- Cultura
                ('Corrida e Resistência', 6, 3),    -- Desportos
                ('Nós e Amarras', 5, 4);            -- Habilidades Escoteiras

insert into Progressao (nome, numRequisitos) values
                 ('Lobo Pata Tenra', 3),
                 ('Lobo Saltador', 4),
                 ('Lobo Rastreador', 5),
                 ('Lobo Caçador', 6),
                 ('Cruzeiro do Sul', 8);

insert into Insignia (nome, numRequisitos) values
    ('Insígnia de Interesse - Robótica', 3);

-- Requisitos da especialidade "Programação Básica"
insert into RequisitoEspecialidade (idEspecialidade, descricao) values
                (1, 'Criar um programa simples com variáveis'),
                (1, 'Entender o que é um algoritmo'),
                (1, 'Usar estruturas de decisão'),
                (1, 'Identificar erros simples no código'),
                (1, 'Trabalhar em equipe em um mini projeto');
                (4, 'Fazer nó direito e nó cego'),
                (4, 'Demonstrar o uso do nó de escota'),
                (4, 'Montar uma amarra quadrada'),
                (4, 'Utilizar os nós em uma atividade real'),
                (4, 'Explicar quando usar cada tipo de nó');

-- Requisitos da Insígnia
insert into RequisitoInsignia (idInsignia, descricao) values
                  (1, 'Participar de 2 oficinas de robótica'),
                  (1, 'Montar um circuito simples com Arduino'),
                  (1, 'Apresentar um projeto em grupo');

-- Requisitos da Progressão "Cruzeiro do Sul"
insert into RequisitoProgressao (idProgressao, descricao) values
                  (5, 'Possuir o distintivo Lobo Caçador'),
                  (5, 'Ter ao menos 1 insígnia de interesse especial'),
                  (5, 'Ter 5 especialidades em 3 áreas diferentes'),
                  (5, 'Ser recomendado por um velho lobo');


insert into Responsavel (nome, telefone, email, idEndereco) values
                    ('Ana Silva', '48999990001', 'ana.silva@email.com', 1),
                    ('Carlos Pereira', '48999990002', 'carlos.pereira@email.com', 2),
                    ('Fernanda Souza', '48999990003', 'fernanda.souza@email.com', 3),
                    ('Marcos Lima', '48999990004', 'marcos.lima@email.com', 4),
                    ('Julia Rocha', '48999990005', 'julia.rocha@email.com', 5),
                    ('Thiago Alves', '48999990006', 'thiago.alves@email.com', 6),
                    ('Roberta Dias', '48999990007', 'roberta.dias@email.com', 1),
                    ('Eduardo Melo', '48999990008', 'eduardo.melo@email.com', 2),
                    ('Vanessa Nunes', '48999990009', 'vanessa.nunes@email.com', 3);

insert into Jovem (nome, dataNascimento, telefone, tipoSanguineo, email, idEndereco) values
                     ('Lucas Martins', '2015-07-10', '48988880001', 'O+', 'lucas@email.com', 1), -- 10 anos
                     ('Marina Lopes', '2017-03-25', '48988880002', 'A+', 'marina@email.com', 2), -- 8
                     ('João Pedro', '2016-09-12', '48988880003', 'B+', 'joao@email.com', 3), -- 9
                     ('Clara Santos', '2018-01-15', '48988880004', 'AB+', 'clara@email.com', 4), -- 7
                     ('Gabriel Souza', '2019-06-18', '48988880005', 'O-', 'gabriel@email.com', 5), -- 6
                     ('Sofia Costa', '2016-11-02', '48988880006', 'A-', 'sofia@email.com', 6), -- 8
                     ('Enzo Lima', '2015-04-08', '48988880007', 'B-', 'enzo@email.com', 1); -- 10


-- Lucas Martins (idJovem = 1) completou todos os requisitos da especialidade 1 (Programação Básica)
insert into RequisitoCumpridoEspecialidade (idJovem, idRequisitoEspecialidade, data) values
                         (1, 1, '2024-08-10'),
                         (1, 2, '2024-08-15'),
                         (1, 3, '2024-08-20'),
                         (1, 4, '2024-08-25'),
                         (1, 5, '2024-09-01');

-- Marina Lopes (idJovem = 2) cumpriu 3 dos 5 requisitos
insert into RequisitoCumpridoEspecialidade (idJovem, idRequisitoEspecialidade, data) values
                         (2, 1, '2024-09-10'),
                         (2, 2, '2024-09-15'),
                         (2, 3, '2024-09-20');7


 -- Lucas Martins (idJovem = 1) completou a Insígnia de Robótica (idInsignia = 1)
insert into RequisitoCumpridoInsignia (idJovem, idRequisitoInsignia, data) values
                    (1, 1, '2024-10-01'),
                    (1, 2, '2024-10-05'),
                    (1, 3, '2024-10-10');

-- Lucas Martins completou todos os requisitos da progressão "Cruzeiro do Sul" (idProgressao = 5)
insert into RequisitoCumpridoProgressao (idJovem, idRequisitoProgressao, data) values
                   (1, 1, '2025-03-01'),  -- Lobo Caçador
                   (1, 2, '2025-03-05'),  -- Insígnia de interesse
                   (1, 3, '2025-03-10'),  -- 5 especialidades
                   (1, 4, '2025-03-15');  -- Recomendado por velho lobo

-- João Pedro (idJovem = 3) completou alguns requisitos da progressão "Lobo Caçador" (idProgressao = 4)
insert into RequisitoCumpridoProgressao (idJovem, idRequisitoProgressao, data) values
    (3, 1, '2025-04-01');  -- Exemplo: ele já fez um dos requisitos

-- Clara (idJovem = 4) cumpriu 2 dos 5 requisitos
insert into RequisitoCumpridoEspecialidade (idJovem, idRequisitoEspecialidade, data) values
     (4, 6, '2025-06-01'),  -- Fazer nó direito e nó cego
     (4, 7, '2025-06-05');  -- Nó de escota


