CREATE TABLE initial.TB_SAMPLE (
   sample_sn      BIGSERIAL PRIMARY KEY, -- PK: 자동으로 증가하는 8바이트 정수 (BigInt 기반)
   title          VARCHAR(255) NOT NULL,
   content        TEXT,
   created_user   VARCHAR(50) NOT NULL,
   created_date   TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
   updated_user   VARCHAR(50),
   updated_date   TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- 테이블 및 컬럼 주석(Comment) 추가
COMMENT ON TABLE initial.TB_SAMPLE IS '샘플 데이터 관리 테이블';
COMMENT ON COLUMN initial.TB_SAMPLE.sample_sn IS '샘플 순번 (PK)';
COMMENT ON COLUMN initial.TB_SAMPLE.title IS '샘플 제목';
COMMENT ON COLUMN initial.TB_SAMPLE.content IS '샘플 내용';
COMMENT ON COLUMN initial.TB_SAMPLE.created_user IS '등록자 ID';
COMMENT ON COLUMN initial.TB_SAMPLE.created_date IS '등록일시';
COMMENT ON COLUMN initial.TB_SAMPLE.updated_user IS '수정자 ID';
COMMENT ON COLUMN initial.TB_SAMPLE.updated_date IS '수정일시';