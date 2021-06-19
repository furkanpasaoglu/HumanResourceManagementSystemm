-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.candidates
(
    user_id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    identity_number character varying(11) NOT NULL UNIQUE CHECK(length(identity_number)>=11 and length(identity_number)<=11),
    year_of_birth date NOT NULL,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (user_id)
);

COMMENT ON TABLE public.candidates
    IS 'İş Arayanlar';

CREATE TABLE public.users
(
    id integer NOT NULL generated always as identity (start with 1 increment by 1),
    email character varying(50) NOT NULL UNIQUE,
    password character varying(20) NOT NULL CHECK(password==confirm_password),
    confirm_password character varying(20) NOT NULL,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (id)
);

COMMENT ON TABLE public.users
    IS 'Kullanıcılar';

CREATE TABLE public.employers
(
    user_id integer NOT NULL,
    company_name character varying(100) NOT NULL,
    website character varying(250) NOT NULL,
    phone character varying(11) NOT NULL,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (user_id)
);

COMMENT ON TABLE public.employers
    IS 'İş Verenler';

CREATE TABLE public.cities
(
    city_id integer NOT NULL generated always as identity (start with 1 increment by 1),
    city_name character varying(25) NOT NULL,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (user_id)
);
CREATE TABLE public.resumes
(
    resume_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    education_id integer,
    work_experience_id integer,
    cover_letter character varying(250) COLLATE pg_catalog."default" NOT NULL,
    github_link character varying(250) COLLATE pg_catalog."default" NOT NULL,
    linkedin_link character varying(250) COLLATE pg_catalog."default" NOT NULL,
    image_url character varying(250) COLLATE pg_catalog."default" NOT NULL DEFAULT true,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    candidate_id integer NOT NULL,
    foreign_language_id integer,
    technology_id integer,
    CONSTRAINT resumes_pkey PRIMARY KEY (resume_id),
        CONSTRAINT fkehbqa88pam7beeaul8s8rgttk FOREIGN KEY (technology_id)
            REFERENCES public.technologies (technology_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION,
        CONSTRAINT fki9aajc3fxlayh1tx0o86jlyd6 FOREIGN KEY (foreign_language_id)
            REFERENCES public.foreign_languages (foreign_language_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION,
        CONSTRAINT fkpwno8g8e6e2242lcq8wmfl68v FOREIGN KEY (education_id)
            REFERENCES public.educations (education_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION,
        CONSTRAINT fktard2t1bf2yqcs6mg0na69cop FOREIGN KEY (work_experience_id)
            REFERENCES public.work_experiences (work_experience_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
);
CREATE TABLE public.work_experiences
(
    work_experience_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    job_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    job_position_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    start_date date NOT NULL,
    end_date date,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    candidate_id integer NOT NULL,
    CONSTRAINT work_experiences_pkey PRIMARY KEY (work_experience_id)
);

CREATE TABLE public.technologies
(
    technology_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    candidate_id integer NOT NULL,
    CONSTRAINT technologies_pkey PRIMARY KEY (technology_id)
);

CREATE TABLE public.foreign_languages
(
    foreign_language_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    language_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    language_level character varying(1) COLLATE pg_catalog."default" NOT NULL,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    candidate_id integer NOT NULL,
    CONSTRAINT foreign_languages_pkey PRIMARY KEY (foreign_language_id)
);
CREATE TABLE public.educations
(
    education_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    school_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    start_date date NOT NULL,
    graduation_date date,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    candidate_id integer NOT NULL,
    CONSTRAINT educations_pkey PRIMARY KEY (education_id)
);

CREATE TABLE public.job_advertisements
(
    job_advertisement_id integer NOT NULL generated always as identity (start with 1 increment by 1),
    employer_id integer NOT NULL,
    job_position_id integer NOT NULL,
    city_id integer NOT NULL,
    salary_min integer,
    salary_max integer,
    number_of_open_job_position character varying(3) NOT NULL,
    application_deadline DATE NOT NULL,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.verifications
(
    user_id integer NOT NULL,
    confirm boolean NOT NULL DEFAULT false,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.system_employees
(
    user_id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (user_id)
);

COMMENT ON TABLE public.system_employees
    IS 'Sistem Personeli';

CREATE TABLE public.employers_verifications
(
    employer_id integer NOT NULL,
    confirm boolean NOT NULL DEFAULT false,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (employer_id)
);

CREATE TABLE public.job_positions
(
    system_employees_id integer NOT NULL,
    name character varying(50) NOT NULL UNIQUE,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    PRIMARY KEY (system_employees_id)
);

COMMENT ON TABLE public.job_positions
    IS 'İş Pozisyonu';
    
CREATE TABLE public.type_of_works
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    CONSTRAINT type_of_works_pkey PRIMARY KEY (id)
);

CREATE TABLE public.job_types
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    create_date date NOT NULL DEFAULT date(now()),
    active boolean NOT NULL DEFAULT true,
    CONSTRAINT job_types_pkey PRIMARY KEY (id)
);


ALTER TABLE public.candidates
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.system_employees
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.verifications
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employers
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.job_positions
    ADD FOREIGN KEY (system_employees_id)
    REFERENCES public.system_employees (user_id)
    NOT VALID;


ALTER TABLE public.employers_verifications
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (user_id)
    NOT VALID;

END;
