package org.example.kinoxpbackend.security.api;


import io.swagger.v3.oas.annotations.Operation;
import org.example.kinoxpbackend.security.dto.UserWithRolesRequest;
import org.example.kinoxpbackend.security.dto.UserWithRolesResponse;
import org.example.kinoxpbackend.security.service.UserWithRolesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user-with-role")
public class UserWithRoleController {

  UserWithRolesService userWithRolesService;

  public UserWithRoleController(UserWithRolesService userWithRolesService) {
    this.userWithRolesService = userWithRolesService;
  }

  //Anonymous users can call this.
  @PostMapping
  @Operation(summary = "Add a new UserWithRoles user",
             description = "If a default role is defined (app.default-role ), this role will be assigned to the user.")
  public UserWithRolesResponse addUserWithRoles(@RequestBody UserWithRolesRequest request) {
    return userWithRolesService.addUserWithRoles(request);
  }

  //Take care with this. This should NOT be something everyone can call
  @PreAuthorize("hasAuthority('ADMIN')")
  @PatchMapping("/add-role/{username}/{role}")
  @Operation(summary = "Add a role to a UserWithRoles", description = "Caller must be authenticated with the role ADMIN")
  public UserWithRolesResponse addRole(@PathVariable String username, @PathVariable String role) {
    return userWithRolesService.addRole(username, role);
  }

  //Take care with this. This should NOT be something everyone can call
  @PreAuthorize("hasAuthority('ADMIN')")
  @PatchMapping("/remove-role/{username}/{role}")
  @Operation(summary = "Removes a role from a UserWithRoles", description = "Caller must be authenticated with the role ADMIN")
  public UserWithRolesResponse removeRole(@PathVariable String username, @PathVariable String role) {
    return userWithRolesService.removeRole(username, role);
  }
}
