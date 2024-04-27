/*
 * **
 *  * @project : SuiviColis
 *  * @created : 27/04/2024, 17:50
 *  * @modified : 27/04/2024, 17:50
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 * **
 */

package com.suivi.colis.suivicolis.securingweb;

import com.suivi.colis.suivicolis.entities.User;
import com.suivi.colis.suivicolis.models.enums.UserStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {
   private final User user;
    private final static String ROLE_PREFIX = "ROLE_";
    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
     List<GrantedAuthority> authorities = new ArrayList<>();
     authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX+this.user.getRole()));
      return List.of();
   }

   @Override
   public String getPassword() {
      return this.user.getPassword();
   }

   @Override
   public String getUsername() {
      return this.user.getEmail();
   }

   @Override
   public boolean isAccountNonExpired() {
      return !this.user.getStatus().equals(UserStatus.EXPIRED);
   }

   @Override
   public boolean isAccountNonLocked() {
      return !this.user.getStatus().equals(UserStatus.LOCKED);
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return !this.user.getStatus().equals(UserStatus.DISABLED);
   }
}
