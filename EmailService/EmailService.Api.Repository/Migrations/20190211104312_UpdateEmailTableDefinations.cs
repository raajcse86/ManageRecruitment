using Microsoft.EntityFrameworkCore.Migrations;

namespace EmailService.Api.Repositories.Migrations
{
    public partial class UpdateEmailTableDefinations : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "Address",
                table: "Emails",
                newName: "ToAddress");

            migrationBuilder.AlterColumn<string>(
                name: "Subject",
                table: "Emails",
                maxLength: 150,
                nullable: true,
                oldClrType: typeof(string),
                oldNullable: true);

            migrationBuilder.AddColumn<string>(
                name: "BCC",
                table: "Emails",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "CC",
                table: "Emails",
                nullable: true);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "BCC",
                table: "Emails");

            migrationBuilder.DropColumn(
                name: "CC",
                table: "Emails");

            migrationBuilder.RenameColumn(
                name: "ToAddress",
                table: "Emails",
                newName: "Address");

            migrationBuilder.AlterColumn<string>(
                name: "Subject",
                table: "Emails",
                nullable: true,
                oldClrType: typeof(string),
                oldMaxLength: 150,
                oldNullable: true);
        }
    }
}
