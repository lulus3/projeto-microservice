CREATE TABLE projects (
    id VARCHAR(36) NOT NULL UNIQUE DEFAULT(UUID()),
    created_date_at DATETIME,
    updated_date_at DATETIME,
    organization VARCHAR(255),
    business_unit VARCHAR(255),
    owner VARCHAR(255),
    region_type VARCHAR(255),
    credential VARCHAR(255),
    ict_enterprise VARCHAR(255),
    owner_foxconn VARCHAR(255),
    project_name VARCHAR(255),
    project_nickname VARCHAR(255),
    start_date DATE,
    end_date DATE,
    cost DOUBLE,
    PRIMARY KEY (id)
);
