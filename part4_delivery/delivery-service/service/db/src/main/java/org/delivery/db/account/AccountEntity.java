package org.delivery.db.account;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;

// 부모로부터 받은 변수도 상속시켜서 빌더패턴으로 사용가능함.
@SuperBuilder
@Data
// 객체 비교 시 부모의 있는 값도 비교해서 사용할거라 true로 값을 준다.
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {
}
