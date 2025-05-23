package application;

import entities.Address;
import entities.Department;
import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String departamento = sc.nextLine();
        System.out.print("Dia do pagamento: ");
        int pagamento = sc.nextInt();
        System.out.print("Email: ");
        sc.nextLine();
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Quantos funcionários tem o departamento? ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        List<Employee> employees = new ArrayList<>();
        Address address = new Address(email, telefone);

        Department dept = new Department(departamento, pagamento, address);

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Dados do funcionário " + (i+1));

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Salário: ");
            double salario = sc.nextDouble();
            sc.nextLine();

            Employee employee = new Employee(nome, salario);
            dept.addEmployee(employee);
        }

        showReport(dept);

        sc.close();
    }

    private static void showReport(Department dept) {
        StringBuilder sb = new StringBuilder();

        sb.append("FOLHA DE PAGAMENTO:\n");
        sb.append("Departamento " + dept.getName()).append(" = R$ ").append(String.format("%.2f ", dept.payRoll())).append("\n");
        sb.append("Pagamento realizado no dia ").append(dept.getPayDay()).append("\n");
        sb.append("Funcionários: ").append("\n");
        for (Employee employee : dept.getEmployees()) {
            sb.append(employee.getName()).append("\n");
        }
        sb.append("Para dúvidas favor entrar em contato: ").append(dept.getAddress().getEmail());

        System.out.println(sb.toString());

    }
}
