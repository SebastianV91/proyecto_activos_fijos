PGDMP                         |            db_activosfijos    14.4    14.4 ,               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16480    db_activosfijos    DATABASE     n   CREATE DATABASE db_activosfijos WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Colombia.1252';
    DROP DATABASE db_activosfijos;
                root    false                        2615    16599    bienes_activos    SCHEMA        CREATE SCHEMA bienes_activos;
    DROP SCHEMA bienes_activos;
                root    false            �            1259    16655    activo_fijo    TABLE     �  CREATE TABLE bienes_activos.activo_fijo (
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
 '   DROP TABLE bienes_activos.activo_fijo;
       bienes_activos         heap    root    false    4            �            1259    16735    activo_fijo_id_activo_fijo_seq    SEQUENCE     �   CREATE SEQUENCE bienes_activos.activo_fijo_id_activo_fijo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE bienes_activos.activo_fijo_id_activo_fijo_seq;
       bienes_activos          root    false    4    212                       0    0    activo_fijo_id_activo_fijo_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE bienes_activos.activo_fijo_id_activo_fijo_seq OWNED BY bienes_activos.activo_fijo.id;
          bienes_activos          root    false    219            �            1259    16698    area    TABLE     �   CREATE TABLE bienes_activos.area (
    id integer NOT NULL,
    id_activo_fijo integer NOT NULL,
    id_ciudad integer NOT NULL,
    nombre_area character varying(50)
);
     DROP TABLE bienes_activos.area;
       bienes_activos         heap    root    false    4            �            1259    16701    area_idarea_seq    SEQUENCE     �   CREATE SEQUENCE bienes_activos.area_idarea_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE bienes_activos.area_idarea_seq;
       bienes_activos          root    false    4    213                        0    0    area_idarea_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE bienes_activos.area_idarea_seq OWNED BY bienes_activos.area.id;
          bienes_activos          root    false    214            �            1259    16702    ciudad    TABLE     b   CREATE TABLE bienes_activos.ciudad (
    id integer NOT NULL,
    nombre character varying(50)
);
 "   DROP TABLE bienes_activos.ciudad;
       bienes_activos         heap    root    false    4            �            1259    16733    ciudad_idciudad_seq    SEQUENCE     �   CREATE SEQUENCE bienes_activos.ciudad_idciudad_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE bienes_activos.ciudad_idciudad_seq;
       bienes_activos          root    false    4    215            !           0    0    ciudad_idciudad_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE bienes_activos.ciudad_idciudad_seq OWNED BY bienes_activos.ciudad.id;
          bienes_activos          root    false    218            �            1259    16706    persona    TABLE     "  CREATE TABLE bienes_activos.persona (
    id integer NOT NULL,
    id_activo_fijo integer NOT NULL,
    primer_nombre character varying(50),
    segundo_nombre character varying(50),
    primer_apellido character varying(50),
    segundo_apellido character varying(50),
    edad integer
);
 #   DROP TABLE bienes_activos.persona;
       bienes_activos         heap    root    false    4            �            1259    16709    persona_idpersona_seq    SEQUENCE     �   CREATE SEQUENCE bienes_activos.persona_idpersona_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE bienes_activos.persona_idpersona_seq;
       bienes_activos          root    false    216    4            "           0    0    persona_idpersona_seq    SEQUENCE OWNED BY     X   ALTER SEQUENCE bienes_activos.persona_idpersona_seq OWNED BY bienes_activos.persona.id;
          bienes_activos          root    false    217            �            1259    16615    tipo_activo    TABLE     g   CREATE TABLE bienes_activos.tipo_activo (
    id integer NOT NULL,
    nombre character varying(50)
);
 '   DROP TABLE bienes_activos.tipo_activo;
       bienes_activos         heap    root    false    4            �            1259    16618    tipo_activo_idtipo_activo_seq    SEQUENCE     �   CREATE SEQUENCE bienes_activos.tipo_activo_idtipo_activo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE bienes_activos.tipo_activo_idtipo_activo_seq;
       bienes_activos          root    false    4    210            #           0    0    tipo_activo_idtipo_activo_seq    SEQUENCE OWNED BY     d   ALTER SEQUENCE bienes_activos.tipo_activo_idtipo_activo_seq OWNED BY bienes_activos.tipo_activo.id;
          bienes_activos          root    false    211            r           2604    16736    activo_fijo id    DEFAULT     �   ALTER TABLE ONLY bienes_activos.activo_fijo ALTER COLUMN id SET DEFAULT nextval('bienes_activos.activo_fijo_id_activo_fijo_seq'::regclass);
 E   ALTER TABLE bienes_activos.activo_fijo ALTER COLUMN id DROP DEFAULT;
       bienes_activos          root    false    219    212            s           2604    16737    area id    DEFAULT     v   ALTER TABLE ONLY bienes_activos.area ALTER COLUMN id SET DEFAULT nextval('bienes_activos.area_idarea_seq'::regclass);
 >   ALTER TABLE bienes_activos.area ALTER COLUMN id DROP DEFAULT;
       bienes_activos          root    false    214    213            t           2604    16734 	   ciudad id    DEFAULT     |   ALTER TABLE ONLY bienes_activos.ciudad ALTER COLUMN id SET DEFAULT nextval('bienes_activos.ciudad_idciudad_seq'::regclass);
 @   ALTER TABLE bienes_activos.ciudad ALTER COLUMN id DROP DEFAULT;
       bienes_activos          root    false    218    215            u           2604    16738 
   persona id    DEFAULT        ALTER TABLE ONLY bienes_activos.persona ALTER COLUMN id SET DEFAULT nextval('bienes_activos.persona_idpersona_seq'::regclass);
 A   ALTER TABLE bienes_activos.persona ALTER COLUMN id DROP DEFAULT;
       bienes_activos          root    false    217    216            q           2604    16619    tipo_activo id    DEFAULT     �   ALTER TABLE ONLY bienes_activos.tipo_activo ALTER COLUMN id SET DEFAULT nextval('bienes_activos.tipo_activo_idtipo_activo_seq'::regclass);
 E   ALTER TABLE bienes_activos.tipo_activo ALTER COLUMN id DROP DEFAULT;
       bienes_activos          root    false    211    210                      0    16655    activo_fijo 
   TABLE DATA           �   COPY bienes_activos.activo_fijo (id, nombre, descripcion, serial, num_interno_inventario, peso, alto, ancho, largo, valor_compra, fecha_compra, id_tipo_activo) FROM stdin;
    bienes_activos          root    false    212   �4                 0    16698    area 
   TABLE DATA           R   COPY bienes_activos.area (id, id_activo_fijo, id_ciudad, nombre_area) FROM stdin;
    bienes_activos          root    false    213   �6                 0    16702    ciudad 
   TABLE DATA           4   COPY bienes_activos.ciudad (id, nombre) FROM stdin;
    bienes_activos          root    false    215   7                 0    16706    persona 
   TABLE DATA           �   COPY bienes_activos.persona (id, id_activo_fijo, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, edad) FROM stdin;
    bienes_activos          root    false    216   ^7                 0    16615    tipo_activo 
   TABLE DATA           9   COPY bienes_activos.tipo_activo (id, nombre) FROM stdin;
    bienes_activos          root    false    210   �7       $           0    0    activo_fijo_id_activo_fijo_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('bienes_activos.activo_fijo_id_activo_fijo_seq', 17, true);
          bienes_activos          root    false    219            %           0    0    area_idarea_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('bienes_activos.area_idarea_seq', 3, true);
          bienes_activos          root    false    214            &           0    0    ciudad_idciudad_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('bienes_activos.ciudad_idciudad_seq', 4, true);
          bienes_activos          root    false    218            '           0    0    persona_idpersona_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('bienes_activos.persona_idpersona_seq', 7, true);
          bienes_activos          root    false    217            (           0    0    tipo_activo_idtipo_activo_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('bienes_activos.tipo_activo_idtipo_activo_seq', 8, true);
          bienes_activos          root    false    211            y           2606    16711    activo_fijo activo_fijo_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY bienes_activos.activo_fijo
    ADD CONSTRAINT activo_fijo_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY bienes_activos.activo_fijo DROP CONSTRAINT activo_fijo_pkey;
       bienes_activos            root    false    212            {           2606    16713    area area_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY bienes_activos.area
    ADD CONSTRAINT area_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY bienes_activos.area DROP CONSTRAINT area_pkey;
       bienes_activos            root    false    213            }           2606    16715    ciudad ciudad_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY bienes_activos.ciudad
    ADD CONSTRAINT ciudad_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY bienes_activos.ciudad DROP CONSTRAINT ciudad_pkey;
       bienes_activos            root    false    215                       2606    16717    persona persona_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY bienes_activos.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY bienes_activos.persona DROP CONSTRAINT persona_pkey;
       bienes_activos            root    false    216            w           2606    16631    tipo_activo tipo_activo_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY bienes_activos.tipo_activo
    ADD CONSTRAINT tipo_activo_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY bienes_activos.tipo_activo DROP CONSTRAINT tipo_activo_pkey;
       bienes_activos            root    false    210            �           2606    16660 +   activo_fijo activo_fijo_id_tipo_activo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY bienes_activos.activo_fijo
    ADD CONSTRAINT activo_fijo_id_tipo_activo_fkey FOREIGN KEY (id_tipo_activo) REFERENCES bienes_activos.tipo_activo(id);
 ]   ALTER TABLE ONLY bienes_activos.activo_fijo DROP CONSTRAINT activo_fijo_id_tipo_activo_fkey;
       bienes_activos          root    false    212    3191    210            �           2606    16718    area area_id_activo_fijo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY bienes_activos.area
    ADD CONSTRAINT area_id_activo_fijo_fkey FOREIGN KEY (id_activo_fijo) REFERENCES bienes_activos.activo_fijo(id);
 O   ALTER TABLE ONLY bienes_activos.area DROP CONSTRAINT area_id_activo_fijo_fkey;
       bienes_activos          root    false    213    3193    212            �           2606    16723    area area_id_ciudad_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY bienes_activos.area
    ADD CONSTRAINT area_id_ciudad_fkey FOREIGN KEY (id_ciudad) REFERENCES bienes_activos.ciudad(id);
 J   ALTER TABLE ONLY bienes_activos.area DROP CONSTRAINT area_id_ciudad_fkey;
       bienes_activos          root    false    215    213    3197            �           2606    16728 #   persona persona_id_activo_fijo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY bienes_activos.persona
    ADD CONSTRAINT persona_id_activo_fijo_fkey FOREIGN KEY (id_activo_fijo) REFERENCES bienes_activos.activo_fijo(id);
 U   ALTER TABLE ONLY bienes_activos.persona DROP CONSTRAINT persona_id_activo_fijo_fkey;
       bienes_activos          root    false    3193    212    216               �  x�m��n�0���S�"��(��"��)P,�m!�
��jѽ��lm�a:%�ϟ&ؗiJꩴ�k+����U�YeN�ђgp�A ��F�!ژ�14�;,�<J�>a�R��`�O��<�h^hn��,��:垦r�׵k��� &C ̀Z6h5�k��<��S/��{Tț�/�hv7����KO�����ʜ�Z�\�������Du $���`�o�W�Iݕ����T�,�,�%�|:��� &$A0�/�QX/n��I[N4�5�V��!�.~�ڦ��yɼ�VO�*٘I�F>��%��N,`�D�Ѓ%�g}ʌ���#�]��kUV������x�Q ��ii˒�C������4Pr0\�n�����cUyVx}"���_���h%(�E#jN���[	��=�ol���         \   x���	�0�R� ���>p>�l���f9���u�)�n�ƙb��� ��']tRf|�%"��*��K���n+29�y��;��i�z         9   x�3�v�qT�u
q�2�tr
r����q�2�t�w���p:;�xr��qqq -�         Q   x��1
�0�z�Ac{�#D4{1���w�j�ٰ�4Wo����Rh�0?�b�C��z��"�Q]�����:�B?8M-         O   x�%ʻ�0�:o�L@�g F��!q:��$�9��pǒ�RI�-<�%J!�cMJ�5!l��O���z��g��l     