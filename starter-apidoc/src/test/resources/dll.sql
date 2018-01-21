DROP TABLE IF EXISTS waybill;
CREATE TABLE waybill
(
  id                      BIGINT NOT NULL AUTO_INCREMENT
  COMMENT '主键ID',
  sys_no                  VARCHAR(100) COMMENT '系统运单号',
  goods_no                VARCHAR(100) COMMENT '货物运单号',
  goods_num               INT             DEFAULT 0
  COMMENT '货物数量',
  cost                    BIGINT COMMENT '寄货费用（单位：分）',
  distribution_name       VARCHAR(100) COMMENT '配送人员姓名',
  distribution_tel        VARCHAR(100) COMMENT '配送人员联系电话',
  distribution_date       BIGINT COMMENT '开始配送时间（毫秒数）',
  eta                     BIGINT COMMENT '预计到达时间（毫秒数）',
  finish_time             BIGINT COMMENT '完成时间（毫秒数）',
  consignee_name          VARCHAR(100) COMMENT '收货人姓名',
  consignee_tel           VARCHAR(100) COMMENT '收货人电话',
  consignee_address       VARCHAR(250) COMMENT '收货人的地址',
  consignor_name          VARCHAR(100) COMMENT '发货人姓名',
  consignor_tel           VARCHAR(100) COMMENT '发货人电话',
  consignor_address       VARCHAR(250) COMMENT '发货人地址',
  status                  INT    NOT NULL DEFAULT 0
  COMMENT '状态（0：等待配送，1：开始配送，2：中转，3：签收，4：其他成功情况，5：拒收，6：其他失败情况，7：收到退货，8：滞留，9：自提，10：生成新运单，11：其他，12：完成）',
  status_desc             VARCHAR(200) COMMENT '订单状态描述',
  finished                BOOL            DEFAULT 0
  COMMENT '是否完成运单',
  company_id              BIGINT NOT NULL
  COMMENT '所属公司',
  area                    VARCHAR(250) COMMENT '所属区域',
  created_date            BIGINT COMMENT '下单时间（毫秒数）',
  last_modified_date      BIGINT COMMENT '上次修改时间（毫秒数）',
  sys_user_id             BIGINT COMMENT '制单人ID',
  sys_user_job_number     VARCHAR(100) COMMENT '制单人工号',
  distribution_id         BIGINT COMMENT '配送人ID',
  distribution_job_number VARCHAR(100) COMMENT '配送人工号',
  lat                     DOUBLE COMMENT '配送地址纬度',
  lng                     DOUBLE COMMENT '配送地址经度',
  planned_start_time      BIGINT COMMENT '计划配送开始时间（毫秒数）',
  planned_end_time        BIGINT COMMENT '计划配送结束时间（毫秒数）',
  old_waybill_id          BIGINT COMMENT '旧运单ID',
  note                    VARCHAR(250) COMMENT '备注',
  bill_copy               TEXT COMMENT '底单图片地址',
  new_waybill_id          BIGINT COMMENT '新运单ID',
  new_waybill_sys_no      VARCHAR(200) COMMENT '新运单系统单号',
  old_waybill_sys_no      VARCHAR(200) COMMENT '旧运单系统单号',
  weight                  INT COMMENT '总重量（单位g）',
  deleted                 BOOL            DEFAULT 0
  COMMENT '是否删除',
  case_no                 VARCHAR(20) COMMENT '箱号',
  add_case_cost           INT             DEFAULT 0
  COMMENT '加箱费（单位：分）',
  renewal_cost            INT             DEFAULT 0
  COMMENT '续重费（单位：分）',
  cargo_value             INT             DEFAULT 0
  COMMENT '货值（单位：分）',
  renewal_type            INT             DEFAULT 0
  COMMENT '续重费谁出（0：用户出，1：伊藤出）',
  has_route               BOOL   NOT NULL DEFAULT 0
  COMMENT '是否有轨迹信息',
  user_deleted            BOOL            DEFAULT 0
  COMMENT '用户删除标记',
  PRIMARY KEY (id)
);

ALTER TABLE waybill
  COMMENT '运单';