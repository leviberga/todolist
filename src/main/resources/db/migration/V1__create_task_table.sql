CREATE TABLE tasks (
task_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
name VARCHAR(100) NOT NULL,
description VARCHAR(300) NOT NULL,
is_done BOOLEAN NOT NULL DEFAULT FALSE,
priority VARCHAR(20) NOT NULL
);
ALTER TABLE tasks
ADD CONSTRAINT check_priority
CHECK (priority IN ('LOW', 'MEDIUM', 'HIGH'));