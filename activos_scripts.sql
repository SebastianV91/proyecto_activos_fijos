--
-- PostgreSQL database dump
--

-- Dumped from database version 14.4
-- Dumped by pg_dump version 14.4

-- Started on 2022-08-12 10:22:24

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 16599)
-- Name: bienes_activos; Type: SCHEMA; Schema: -; Owner: root
--

CREATE SCHEMA bienes_activos;


ALTER SCHEMA bienes_activos OWNER TO root;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 212 (class 1259 OID 16655)
-- Name: activo_fijo; Type: TABLE; Schema: bienes_activos; Owner: root
--

CREATE TABLE bienes_activos.activo_fijo (
    id integer NOT NULL,
    nombre character varying(50),
    descripcion text,
    serial character varying,
    num_interno_inventario character varying(50),
    peso double precision,
    alto double precision,
    ancho double precision,
    largo double precision,
    valor_compra integer,
    fecha_compra date,
    id_tipo_activo integer
);


ALTER TABLE bienes_activos.activo_fijo OWNER TO root;

--
-- TOC entry 219 (class 1259 OID 16735)
-- Name: activo_fijo_id_activo_fijo_seq; Type: SEQUENCE; Schema: bienes_activos; Owner: root
--

CREATE SEQUENCE bienes_activos.activo_fijo_id_activo_fijo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE bienes_activos.activo_fijo_id_activo_fijo_seq OWNER TO root;

--
-- TOC entry 3358 (class 0 OID 0)
-- Dependencies: 219
-- Name: activo_fijo_id_activo_fijo_seq; Type: SEQUENCE OWNED BY; Schema: bienes_activos; Owner: root
--

ALTER SEQUENCE bienes_activos.activo_fijo_id_activo_fijo_seq OWNED BY bienes_activos.activo_fijo.id;


--
-- TOC entry 213 (class 1259 OID 16698)
-- Name: area; Type: TABLE; Schema: bienes_activos; Owner: root
--

CREATE TABLE bienes_activos.area (
    id integer NOT NULL,
    id_activo_fijo integer NOT NULL,
    id_ciudad integer NOT NULL,
    nombre_area character varying(50)
);


ALTER TABLE bienes_activos.area OWNER TO root;

--
-- TOC entry 214 (class 1259 OID 16701)
-- Name: area_idarea_seq; Type: SEQUENCE; Schema: bienes_activos; Owner: root
--

CREATE SEQUENCE bienes_activos.area_idarea_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE bienes_activos.area_idarea_seq OWNER TO root;

--
-- TOC entry 3359 (class 0 OID 0)
-- Dependencies: 214
-- Name: area_idarea_seq; Type: SEQUENCE OWNED BY; Schema: bienes_activos; Owner: root
--

ALTER SEQUENCE bienes_activos.area_idarea_seq OWNED BY bienes_activos.area.id;


--
-- TOC entry 215 (class 1259 OID 16702)
-- Name: ciudad; Type: TABLE; Schema: bienes_activos; Owner: root
--

CREATE TABLE bienes_activos.ciudad (
    id integer NOT NULL,
    nombre character varying(50)
);


ALTER TABLE bienes_activos.ciudad OWNER TO root;

--
-- TOC entry 218 (class 1259 OID 16733)
-- Name: ciudad_idciudad_seq; Type: SEQUENCE; Schema: bienes_activos; Owner: root
--

CREATE SEQUENCE bienes_activos.ciudad_idciudad_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE bienes_activos.ciudad_idciudad_seq OWNER TO root;

--
-- TOC entry 3360 (class 0 OID 0)
-- Dependencies: 218
-- Name: ciudad_idciudad_seq; Type: SEQUENCE OWNED BY; Schema: bienes_activos; Owner: root
--

ALTER SEQUENCE bienes_activos.ciudad_idciudad_seq OWNED BY bienes_activos.ciudad.id;


--
-- TOC entry 216 (class 1259 OID 16706)
-- Name: persona; Type: TABLE; Schema: bienes_activos; Owner: root
--

CREATE TABLE bienes_activos.persona (
    id integer NOT NULL,
    id_activo_fijo integer NOT NULL,
    primer_nombre character varying(50),
    segundo_nombre character varying(50),
    primer_apellido character varying(50),
    segundo_apellido character varying(50),
    edad integer
);


ALTER TABLE bienes_activos.persona OWNER TO root;

--
-- TOC entry 217 (class 1259 OID 16709)
-- Name: persona_idpersona_seq; Type: SEQUENCE; Schema: bienes_activos; Owner: root
--

CREATE SEQUENCE bienes_activos.persona_idpersona_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE bienes_activos.persona_idpersona_seq OWNER TO root;

--
-- TOC entry 3361 (class 0 OID 0)
-- Dependencies: 217
-- Name: persona_idpersona_seq; Type: SEQUENCE OWNED BY; Schema: bienes_activos; Owner: root
--

ALTER SEQUENCE bienes_activos.persona_idpersona_seq OWNED BY bienes_activos.persona.id;


--
-- TOC entry 210 (class 1259 OID 16615)
-- Name: tipo_activo; Type: TABLE; Schema: bienes_activos; Owner: root
--

CREATE TABLE bienes_activos.tipo_activo (
    id integer NOT NULL,
    nombre character varying(50)
);


ALTER TABLE bienes_activos.tipo_activo OWNER TO root;

--
-- TOC entry 211 (class 1259 OID 16618)
-- Name: tipo_activo_idtipo_activo_seq; Type: SEQUENCE; Schema: bienes_activos; Owner: root
--

CREATE SEQUENCE bienes_activos.tipo_activo_idtipo_activo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE bienes_activos.tipo_activo_idtipo_activo_seq OWNER TO root;

--
-- TOC entry 3362 (class 0 OID 0)
-- Dependencies: 211
-- Name: tipo_activo_idtipo_activo_seq; Type: SEQUENCE OWNED BY; Schema: bienes_activos; Owner: root
--

ALTER SEQUENCE bienes_activos.tipo_activo_idtipo_activo_seq OWNED BY bienes_activos.tipo_activo.id;


--
-- TOC entry 3186 (class 2604 OID 16736)
-- Name: activo_fijo id; Type: DEFAULT; Schema: bienes_activos; Owner: root
--

ALTER TABLE ONLY bienes_activos.activo_fijo ALTER COLUMN id SET DEFAULT nextval('bienes_activos.activo_fijo_id_activo_fijo_seq'::regclass);


--
-- TOC entry 3187 (class 2604 OID 16737)
-- Name: area id; Type: DEFAULT; Schema: bienes_activos; Owner: root
--

ALTER TABLE ONLY bienes_activos.area ALTER COLUMN id SET DEFAULT nextval('bienes_activos.area_idarea_seq'::regclass);


--
-- TOC entry 3188 (class 2604 OID 16734)
-- Name: ciudad id; Type: DEFAULT; Schema: bienes_activos; Owner: root
--

ALTER TABLE ONLY bienes_activos.ciudad ALTER COLUMN id SET DEFAULT nextval('bienes_activos.ciudad_idciudad_seq'::regclass);


--
-- TOC entry 3189 (class 2604 OID 16738)
-- Name: persona id; Type: DEFAULT; Schema: bienes_activos; Owner: root
--

ALTER TABLE ONLY bienes_activos.persona ALTER COLUMN id SET DEFAULT nextval('bienes_activos.persona_idpersona_seq'::regclass);


--
-- TOC entry 3185 (class 2604 OID 16619)
-- Name: tipo_activo id; Type: DEFAULT; Schema: bienes_activos; Owner: root
--

ALTER TABLE ONLY bienes_activos.tipo_activo ALTER COLUMN id SET DEFAULT nextval('bienes_activos.tipo_activo_idtipo_activo_seq'::regclass);


--
-- TOC entry 3343 (class 0 OID 16615)
-- Dependencies: 210
-- Data for Name: tipo_activo; Type: TABLE DATA; Schema: bienes_activos; Owner: root
--

COPY bienes_activos.tipo_activo (id, nombre) FROM stdin;
1	INMUEBLES
2	MUEBLES
3	EQUIPAMIENTO OFIMATICO
4	MAQUINARIA
5	EQUIPOS DE TRANSPORTE
6	DERECHOS DE PATENTES
7	INVERSIONES
\.

--
-- TOC entry 3367 (class 0 OID 0)
-- Dependencies: 211
-- Name: tipo_activo_idtipo_activo_seq; Type: SEQUENCE SET; Schema: bienes_activos; Owner: root
--

SELECT pg_catalog.setval('bienes_activos.tipo_activo_idtipo_activo_seq', 8, true);


--
-- TOC entry 3193 (class 2606 OID 16711)
-- Name: activo_fijo activo_fijo_pkey; Type: CONSTRAINT; Schema: bienes_activos; Owner: root
--

ALTER TABLE ONLY bienes_activos.activo_fijo
    ADD CONSTRAINT activo_fijo_pkey PRIMARY KEY (id);


--
-- TOC entry 3195 (class 2606 OID 16713)
-- Name: area area_pkey; Type: CONSTRAINT; Schema: bienes_activos; Owner: root
--

ALTER TABLE ONLY bienes_activos.area
    ADD CONSTRAINT area_pkey PRIMARY KEY (id);


--
-- TOC entry 3197 (class 2606 OID 16715)
-- Name: ciudad ciudad_pkey; Type: CONSTRAINT; Schema: bienes_activos; Owner: root
--

ALTER TABLE ONLY bienes_activos.ciudad
    ADD CONSTRAINT ciudad_pkey PRIMARY KEY (id);


--
-- TOC entry 3199 (class 2606 OID 16717)
-- Name: persona persona_pkey; Type: CONSTRAINT; Schema: bienes_activos; Owner: root
--

ALTER TABLE ONLY bienes_activos.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id);


--
-- TOC entry 3191 (class 2606 OID 16631)
-- Name: tipo_activo tipo_activo_pkey; Type: CONSTRAINT; Schema: bienes_activos; Owner: root
--

ALTER TABLE ONLY bienes_activos.tipo_activo
    ADD CONSTRAINT tipo_activo_pkey PRIMARY KEY (id);


--
-- TOC entry 3200 (class 2606 OID 16660)
-- Name: activo_fijo activo_fijo_id_tipo_activo_fkey; Type: FK CONSTRAINT; Schema: bienes_activos; Owner: root
--

ALTER TABLE ONLY bienes_activos.activo_fijo
    ADD CONSTRAINT activo_fijo_id_tipo_activo_fkey FOREIGN KEY (id_tipo_activo) REFERENCES bienes_activos.tipo_activo(id);


--
-- TOC entry 3201 (class 2606 OID 16718)
-- Name: area area_id_activo_fijo_fkey; Type: FK CONSTRAINT; Schema: bienes_activos; Owner: root
--

ALTER TABLE ONLY bienes_activos.area
    ADD CONSTRAINT area_id_activo_fijo_fkey FOREIGN KEY (id_activo_fijo) REFERENCES bienes_activos.activo_fijo(id);


--
-- TOC entry 3202 (class 2606 OID 16723)
-- Name: area area_id_ciudad_fkey; Type: FK CONSTRAINT; Schema: bienes_activos; Owner: root
--

ALTER TABLE ONLY bienes_activos.area
    ADD CONSTRAINT area_id_ciudad_fkey FOREIGN KEY (id_ciudad) REFERENCES bienes_activos.ciudad(id);


--
-- TOC entry 3203 (class 2606 OID 16728)
-- Name: persona persona_id_activo_fijo_fkey; Type: FK CONSTRAINT; Schema: bienes_activos; Owner: root
--

ALTER TABLE ONLY bienes_activos.persona
    ADD CONSTRAINT persona_id_activo_fijo_fkey FOREIGN KEY (id_activo_fijo) REFERENCES bienes_activos.activo_fijo(id);


-- Completed on 2022-08-12 10:22:24

--
-- PostgreSQL database dump complete
--

