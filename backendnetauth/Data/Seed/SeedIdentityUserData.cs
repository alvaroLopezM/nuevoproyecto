using backendnet.Models;
using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;

namespace backendnet.Data.Seed;

public static class SeedIdentityUserData
{
    public static void SeedUserIdentityData(this ModelBuilder modelBuilder)
    {
        //Agregar rol "Administrador" a tabla AspNetRoles
        string AdministradorRoleId = Guid.NewGuid().ToString(); 
        modelBuilder.Entity<IdentityRole>().HasData(new IdentityRole
        {
            Id = AdministradorRoleId,
            Name = "Administrador",
            NormalizedName = "Administrador".ToUpper()
        });

        //Agregar rol "Usuario" a tabla AspNetRoles
        string UsuarioRoleId = Guid.NewGuid().ToString(); 
        modelBuilder.Entity<IdentityRole>().HasData(new IdentityRole
        {
            Id = UsuarioRoleId,
            Name = "Usuario",
            NormalizedName = "Usuario".ToUpper()
        });

        //Agregar usuario a tabla AspNetRoles
        var UsuarioId = Guid.NewGuid().ToString(); 
        modelBuilder.Entity<CustomIdentityUser>().HasData(new CustomIdentityUser
        {
            Id = UsuarioId,
            UserName = "alopez@uv.mx",
            Email = "alopez@uv.mx",
            NormalizedEmail = "alopez@uv.mx".ToUpper(),
            Nombre = "Alvaro Lopez Martinez",
            NormalizedUserName = "alopez@uv.mx".ToUpper(),
            PasswordHash = new PasswordHasher<CustomIdentityUser>().HashPassword(null!, "patito"),
            Protegido = true //No se puede eliminar
        });

        //Asignar rol
        modelBuilder.Entity<IdentityUserRole<string>>().HasData(new IdentityUserRole<string>
        {
            RoleId = AdministradorRoleId,
            UserId = UsuarioId
        });


    }
}