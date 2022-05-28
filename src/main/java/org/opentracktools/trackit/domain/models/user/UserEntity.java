package org.opentracktools.trackit.domain.models.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.opentracktools.trackit.domain.models.common.BaseEntity;

import java.io.Serial;
import java.util.Date;

/**
 * @author Arpan Mukhopadhyay
 */
@Entity
@Table(name = "users", indexes = {
    @Index(unique = true, name = "index_username_on_users", columnList = "username"),
    @Index(unique = true, name = "index_email_on_users", columnList = "email")
})
@Getter
@Setter
public class UserEntity extends BaseEntity {
  
  @Serial
  private static final long serialVersionUID = -648190166481989180L;
  @Column(name = "username", nullable = false)
  private String username;
  
  @Column(name = "email", nullable = false)
  private String email;
  
  @Column(name = "encrypted_password", nullable = false)
  private String password;
  
  @Column(name = "first_name")
  private String firstName;
  
  @Column(name = "middle_name")
  private String middleName;
  
  @Column(name = "last_name")
  private String lastName;
  
  @Column(name = "address_1")
  private String address1; // Building/Apartment name etc
  
  @Column(name = "address_2")
  private String address2; // Block number/Flat Number etc
  
  @Column(name = "address_3")
  private String address3; // Street
  
  @Column(name = "address_4")
  private String address4; // zip code
  
  @Column(name = "is_admin")
  private boolean admin = false;
  
  @Column(name = "primary_contact_ll")
  private String primaryContactLL; // Landline
  
  @Column(name = "primary_contact_cell")
  private String primaryContactCell; // cell
  
  @Column(name = "bio", length = 512)
  private String bio;
  
  @Column(name = "skype")
  private String skype;
  
  @Column(name = "linked_in")
  private String linkedIn;
  
  @Column(name = "twitter")
  private String twitter;
  
  @Column(name = "avatar", length = 1024)
  private String avatar;
  
  @Column(name = "role", length = 4, nullable = false)
  private short role;
  
  @Column(name = "user_type", length = 4, nullable = false)
  private short userType;
  
  @Column(name = "reset_password_token")
  private String resetPasswordToken;
  
  @Column(name = "reset_password_valid_till")
  private Date resetPasswordValidTill;
  
  @Column(name = "locked")
  private boolean locked = false;
  
  @Column(name = "lock_reason")
  private String lockReason;
  
  /**
   *
   */
  protected UserEntity() {}
  
  /**
   * Creates a new user with the given details.
   *
   * @param username the username
   * @param email the email
   */
  public UserEntity(String username, String email) {
    this.username = username;
    this.email = email;
  }
  
  @Override
  public String toString() {
    return String.format("User<email: %s>", email);
  }
}
