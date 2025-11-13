/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.cli;

import java.io.IOException;
import ucb.aplicativo.control.*;
import ucb.aplicativo.model.*;
import java.util.Scanner;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author JOAO
 */
public class PetPlace {
    private final Scanner scanner;
    private final AdministradorControl adminControl;
    private final ClienteControl clienteControl;
    private final ProdutoControl produtoControl;
    private final FornecedorControl fornecedorControl;
    private final ServicoControl servicoControl;
    private final CompraControl compraControl;
    private final PagamentoPixControl pagamentoPixControl;
    
    // Cor para destacar no terminal (opcional)
    private static final String RESET = "\u001B[0m";
    private static final String VERDE = "\u001B[32m";
    private static final String AZUL = "\u001B[34m";
    private static final String VERMELHO = "\u001B[31m";
    private static final String AMARELO = "\u001B[33m";
    
    public PetPlace() {
        this.scanner = new Scanner(System.in);
        this.adminControl = new AdministradorControl();
        this.clienteControl = new ClienteControl();
        this.produtoControl = new ProdutoControl();
        this.fornecedorControl = new FornecedorControl();
        this.servicoControl = new ServicoControl();
        this.compraControl = new CompraControl();
        this.pagamentoPixControl = new PagamentoPixControl();
    }
    
    public void iniciar() {
        limparTela();
        System.out.println(VERDE + "🐾 BEM-VINDO AO PET PLACE! 🐾" + RESET);
        
        // Menu de login inicial
        while (true) {
            System.out.println("\n" + AZUL + "=== MENU INICIAL ===" + RESET);
            System.out.println("1. 👤 Login Administrador");
            System.out.println("2. 👥 Área do Cliente");
            System.out.println("3. 🚪 Sair");
            System.out.print(AMARELO + "Escolha uma opção: " + RESET);
            
            int opcao = lerInteiro();
            
            switch (opcao) {
                case 1:
                    if (fazerLoginAdmin()) {
                        menuPrincipal();
                    }
                    break;
                case 2:
                    menuClientePublico();
                    break;
                case 3:
                    System.out.println(VERDE + "Obrigado por usar o Pet Place! 🐕🐈" + RESET);
                    return;
                default:
                    System.out.println(VERMELHO + "Opção inválida! Tente novamente." + RESET);
            }
        }
    }
    
    private boolean fazerLoginAdmin() {
        System.out.println("\n" + AZUL + "=== LOGIN ADMINISTRADOR ===" + RESET);
        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        
        try {
            Administrador admin = adminControl.login(usuario, senha);
            System.out.println(VERDE + "✅ Login realizado com sucesso! Bem-vindo, " + admin.getNOME() + RESET);
            pausa(1);
            return true;
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
            pausa(2);
            return false;
        }
    }
    
    private void menuPrincipal() {
        while (true) {
            limparTela();
            System.out.println(VERDE + "\n🐾 PET PLACE - SISTEMA ADMINISTRATIVO 🐾" + RESET);
            System.out.println(AZUL + "=== MENU PRINCIPAL ===" + RESET);
            System.out.println("1. 📦 Gerenciar Produtos");
            System.out.println("2. 👥 Gerenciar Clientes");
            System.out.println("3. 🏢 Gerenciar Fornecedores");
            System.out.println("4. ✂️ Gerenciar Serviços");
            System.out.println("5. 🛒 Gerenciar Compras");
            System.out.println("6. 💰 Gerenciar Pagamentos PIX");
            System.out.println("7. 👑 Gerenciar Administradores");
            System.out.println("0. ↩️ Voltar ao Menu Inicial");
            System.out.print(AMARELO + "Escolha uma opção: " + RESET);
            
            int opcao = lerInteiro();
            
            switch (opcao) {
                case 1: menuProdutos(); break;
                case 2: menuClientes(); break;
                case 3: menuFornecedores(); break;
                case 4: menuServicos(); break;
                case 5: menuCompras(); break;
                case 6: menuPagamentosPix(); break;
                case 7: menuAdministradores(); break;
                case 0: return;
                default: System.out.println(VERMELHO + "Opção inválida!" + RESET);
            }
        }
    }
    
    private void menuClientePublico() {
        while (true) {
            limparTela();
            System.out.println(VERDE + "\n🐾 PET PLACE - ÁREA DO CLIENTE 🐾" + RESET);
            System.out.println(AZUL + "=== MENU CLIENTE ===" + RESET);
            System.out.println("1. 👤 Cadastrar Cliente");
            System.out.println("2. 📦 Ver Produtos Disponíveis");
            System.out.println("3. ✂️ Ver Serviços Disponíveis");
            System.out.println("4. 🛒 Realizar Compra");
            System.out.println("0. ↩️ Voltar");
            System.out.print(AMARELO + "Escolha uma opção: " + RESET);
            
            int opcao = lerInteiro();
            
            switch (opcao) {
                case 1: cadastrarCliente(); break;
                case 2: listarProdutosPublico(); break;
                case 3: listarServicosPublico(); break;
                case 4: realizarCompraCliente(); break;
                case 0: return;
                default: System.out.println(VERMELHO + "Opção inválida!" + RESET);
            }
        }
    }
    
    // ========== MÉTODOS PARA PRODUTOS ==========
    private void menuProdutos() {
        while (true) {
            limparTela();
            System.out.println(AZUL + "\n=== GERENCIAR PRODUTOS ===" + RESET);
            System.out.println("1. ➕ Cadastrar Produto");
            System.out.println("2. 📋 Listar Produtos");
            System.out.println("3. 🔍 Buscar Produto por ID");
            System.out.println("4. ✏️ Atualizar Produto");
            System.out.println("5. 🗑️ Excluir Produto");
            System.out.println("0. ↩️ Voltar");
            System.out.print(AMARELO + "Escolha uma opção: " + RESET);
            
            int opcao = lerInteiro();
            
            switch (opcao) {
                case 1: cadastrarProduto(); break;
                case 2: listarProdutos(); break;
                case 3: buscarProdutoPorId(); break;
                case 4: atualizarProduto(); break;
                case 5: excluirProduto(); break;
                case 0: return;
                default: System.out.println(VERMELHO + "Opção inválida!" + RESET);
            }
        }
    }
    
    private void cadastrarProduto() {
        try {
            System.out.println(AZUL + "\n--- CADASTRAR PRODUTO ---" + RESET);
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Descrição: ");
            String descricao = scanner.nextLine();
            System.out.print("Preço: ");
            BigDecimal preco = new BigDecimal(scanner.nextLine());
            System.out.print("Quantidade em Estoque: ");
            int estoque = lerInteiro();
            
            Produto produto = new Produto(0, nome, descricao, preco, estoque);
            produtoControl.cadastrarProduto(produto);
            System.out.println(VERDE + "✅ Produto cadastrado com sucesso! ID: " + produto.getIdPRODUTO() + RESET);
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }
    
    private void listarProdutos() {
        try {
            System.out.println(AZUL + "\n--- LISTA DE PRODUTOS ---" + RESET);
            List<Produto> produtos = produtoControl.listarTodos();
            if (produtos.isEmpty()) {
                System.out.println(AMARELO + "Nenhum produto cadastrado." + RESET);
            } else {
                for (Produto p : produtos) {
                    System.out.printf("ID: %d | Nome: %s | Preço: R$ %.2f | Estoque: %d\n",
                            p.getIdPRODUTO(), p.getNOME(), p.getPRECO(), p.getQUANTIDADE_ESTOQUE());
                }
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }
    
    // ========== MÉTODOS PARA CLIENTES ==========
    private void menuClientes() {
        while (true) {
            limparTela();
            System.out.println(AZUL + "\n=== GERENCIAR CLIENTES ===" + RESET);
            System.out.println("1. ➕ Cadastrar Cliente");
            System.out.println("2. 📋 Listar Clientes");
            System.out.println("3. 🔍 Buscar Cliente por CPF");
            System.out.println("4. ✏️ Atualizar Cliente");
            System.out.println("5. 🗑️ Excluir Cliente");
            System.out.println("0. ↩️ Voltar");
            System.out.print(AMARELO + "Escolha uma opção: " + RESET);
            
            int opcao = lerInteiro();
            
            switch (opcao) {
                case 1: cadastrarCliente(); break;
                case 2: listarClientes(); break;
                case 3: buscarClientePorCpf(); break;
                case 4: atualizarCliente(); break;
                case 5: excluirCliente(); break;
                case 0: return;
                default: System.out.println(VERMELHO + "Opção inválida!" + RESET);
            }
        }
    }
    
    private void cadastrarCliente() {
        try {
            System.out.println(AZUL + "\n--- CADASTRAR CLIENTE ---" + RESET);
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();
            
            // Para campos de FK, usar 0 como padrão
            Cliente cliente = new Cliente(cpf, nome, telefone, email, endereco, 0, 0);
            clienteControl.cadastrarCliente(cliente);
            System.out.println(VERDE + "✅ Cliente cadastrado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }
    
    private void listarClientes() {
        try {
            System.out.println(AZUL + "\n--- LISTA DE CLIENTES ---" + RESET);
            List<Cliente> clientes = clienteControl.listarClientes();
            if (clientes.isEmpty()) {
                System.out.println(AMARELO + "Nenhum cliente cadastrado." + RESET);
            } else {
                for (Cliente c : clientes) {
                    System.out.printf("CPF: %s | Nome: %s | Email: %s | Tel: %s\n",
                            c.getCpf(), c.getNome(), c.getEmail(), c.getTelefone());
                }
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }
    
    // ========== MÉTODOS PARA SERVIÇOS ==========
    private void menuServicos() {
        while (true) {
            limparTela();
            System.out.println(AZUL + "\n=== GERENCIAR SERVIÇOS ===" + RESET);
            System.out.println("1. ➕ Cadastrar Serviço");
            System.out.println("2. 📋 Listar Serviços");
            System.out.println("3. 🔍 Buscar Serviço por ID");
            System.out.println("4. ✏️ Atualizar Serviço");
            System.out.println("5. 🗑️ Excluir Serviço");
            System.out.println("0. ↩️ Voltar");
            System.out.print(AMARELO + "Escolha uma opção: " + RESET);
            
            int opcao = lerInteiro();
            
            switch (opcao) {
                case 1: cadastrarServico(); break;
                case 2: listarServicos(); break;
                case 3: buscarServicoPorId(); break;
                case 4: atualizarServico(); break;
                case 5: excluirServico(); break;
                case 0: return;
                default: System.out.println(VERMELHO + "Opção inválida!" + RESET);
            }
        }
    }
    
    private void cadastrarServico() {
        try {
            System.out.println(AZUL + "\n--- CADASTRAR SERVIÇO ---" + RESET);
            System.out.print("Preço: ");
            BigDecimal preco = new BigDecimal(scanner.nextLine());
            System.out.print("Oferece Banho? (1-Sim / 0-Não): ");
            int banho = lerInteiro();
            System.out.print("Oferece Tosa? (1-Sim / 0-Não): ");
            int tosa = lerInteiro();
            
            servicoControl.cadastrarServico(preco, banho, tosa);
            System.out.println(VERDE + "✅ Serviço cadastrado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }
    
    // ========== MÉTODOS PARA COMPRAS ==========
    private void realizarCompraCliente() {
        try {
            System.out.println(AZUL + "\n--- REALIZAR COMPRA ---" + RESET);
            System.out.print("CPF do Cliente: ");
            String cpf = scanner.nextLine();
            
            // Verificar se cliente existe
            Cliente cliente = clienteControl.buscarClientePorCpf(cpf);
            System.out.println(VERDE + "Cliente encontrado: " + cliente.getNome() + RESET);
            
            // Listar produtos disponíveis
            listarProdutosPublico();
            
            System.out.print("ID do Produto: ");
            String idProduto = scanner.nextLine();
            System.out.print("Valor Total: ");
            BigDecimal valorTotal = new BigDecimal(scanner.nextLine());
            
            // Criar compra
            Compra compra = new Compra(0, cpf, new Date(System.currentTimeMillis()), 
                                      valorTotal, idProduto, 0);
            compraControl.cadastrarCompra(compra);
            
            System.out.println(VERDE + "✅ Compra realizada com sucesso! ID: " + compra.getIdCOMPRA() + RESET);
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }
    
    // ========== MÉTODOS AUXILIARES ==========
    private void listarProdutosPublico() {
        try {
            System.out.println(AZUL + "\n--- PRODUTOS DISPONÍVEIS ---" + RESET);
            List<Produto> produtos = produtoControl.listarTodos();
            if (produtos.isEmpty()) {
                System.out.println(AMARELO + "Nenhum produto disponível no momento." + RESET);
            } else {
                for (Produto p : produtos) {
                    if (p.getQUANTIDADE_ESTOQUE() > 0) {
                        System.out.printf("ID: %d | %s | R$ %.2f | Estoque: %d\n",
                                p.getIdPRODUTO(), p.getNOME(), p.getPRECO(), p.getQUANTIDADE_ESTOQUE());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro ao carregar produtos: " + e.getMessage() + RESET);
        }
    }
    
    private void listarServicosPublico() {
        try {
            System.out.println(AZUL + "\n--- SERVIÇOS DISPONÍVEIS ---" + RESET);
            List<Servico> servicos = servicoControl.listarServicos();
            if (servicos.isEmpty()) {
                System.out.println(AMARELO + "Nenhum serviço disponível no momento." + RESET);
            } else {
                for (Servico s : servicos) {
                    String servicosOferecidos = "";
                    if (s.getBANHO() == 1) servicosOferecidos += "Banho ";
                    if (s.getTOSA() == 1) servicosOferecidos += "Tosa";
                    System.out.printf("ID: %d | %s | R$ %.2f\n",
                            s.getIdSERVICO(), servicosOferecidos, s.getPRECO());
                }
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro ao carregar serviços: " + e.getMessage() + RESET);
        }
        pausa(3);
    }
    
    // ========== MÉTODOS IMPLEMENTADOS ==========

    // === PRODUTOS ===
    private void buscarProdutoPorId() {
        try {
            System.out.println(AZUL + "\n--- BUSCAR PRODUTO POR ID ---" + RESET);
            System.out.print("ID do Produto: ");
            int id = lerInteiro();

            Produto produto = produtoControl.buscarPorId(id);
            System.out.println(VERDE + "✅ Produto encontrado:" + RESET);
            System.out.printf("ID: %d | Nome: %s | Preço: R$ %.2f | Estoque: %d\n",
                    produto.getIdPRODUTO(), produto.getNOME(), produto.getPRECO(), 
                    produto.getQUANTIDADE_ESTOQUE());
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }

    private void atualizarProduto() {
        try {
            System.out.println(AZUL + "\n--- ATUALIZAR PRODUTO ---" + RESET);
            System.out.print("ID do Produto: ");
            int id = lerInteiro();

            Produto produto = produtoControl.buscarPorId(id);
            System.out.println("Produto atual: " + produto.getNOME());

            System.out.print("Novo Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Nova Descrição: ");
            String descricao = scanner.nextLine();
            System.out.print("Novo Preço: ");
            BigDecimal preco = new BigDecimal(scanner.nextLine());
            System.out.print("Nova Quantidade em Estoque: ");
            int estoque = lerInteiro();

            produto.setNOME(nome);
            produto.setDESCRICAO(descricao);
            produto.setPRECO(preco);
            produto.setQUANTIDADE_ESTOQUE(estoque);

            produtoControl.atualizarProduto(produto);
            System.out.println(VERDE + "✅ Produto atualizado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }

    private void excluirProduto() {
        try {
            System.out.println(AZUL + "\n--- EXCLUIR PRODUTO ---" + RESET);
            System.out.print("ID do Produto a excluir: ");
            int id = lerInteiro();

            System.out.print("Confirma exclusão? (s/n): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                produtoControl.deletarProduto(id);
                System.out.println(VERDE + "✅ Produto excluído com sucesso!" + RESET);
            } else {
                System.out.println(AMARELO + "Operação cancelada." + RESET);
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }

    // === CLIENTES ===
    private void buscarClientePorCpf() {
        try {
            System.out.println(AZUL + "\n--- BUSCAR CLIENTE POR CPF ---" + RESET);
            System.out.print("CPF do Cliente: ");
            String cpf = scanner.nextLine();

            Cliente cliente = clienteControl.buscarClientePorCpf(cpf);
            System.out.println(VERDE + "✅ Cliente encontrado:" + RESET);
            System.out.printf("CPF: %s | Nome: %s | Email: %s | Tel: %s\n",
                    cliente.getCpf(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }

    private void atualizarCliente() {
        try {
            System.out.println(AZUL + "\n--- ATUALIZAR CLIENTE ---" + RESET);
            System.out.print("CPF do Cliente: ");
            String cpf = scanner.nextLine();

            Cliente cliente = clienteControl.buscarClientePorCpf(cpf);
            System.out.println("Cliente atual: " + cliente.getNome());

            System.out.print("Novo Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novo Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Novo Email: ");
            String email = scanner.nextLine();
            System.out.print("Novo Endereço: ");
            String endereco = scanner.nextLine();

            cliente.setNome(nome);
            cliente.setTelefone(telefone);
            cliente.setEmail(email);
            cliente.setEndereco(endereco);

            clienteControl.atualizarCliente(cliente);
            System.out.println(VERDE + "✅ Cliente atualizado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }

    private void excluirCliente() {
        try {
            System.out.println(AZUL + "\n--- EXCLUIR CLIENTE ---" + RESET);
            System.out.print("CPF do Cliente a excluir: ");
            String cpf = scanner.nextLine();

            System.out.print("Confirma exclusão? (s/n): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                clienteControl.deletarCliente(cpf);
                System.out.println(VERDE + "✅ Cliente excluído com sucesso!" + RESET);
            } else {
                System.out.println(AMARELO + "Operação cancelada." + RESET);
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }

    // === SERVIÇOS ===
    private void listarServicos() {
        try {
            System.out.println(AZUL + "\n--- LISTA DE SERVIÇOS ---" + RESET);
            List<Servico> servicos = servicoControl.listarServicos();
            if (servicos.isEmpty()) {
                System.out.println(AMARELO + "Nenhum serviço cadastrado." + RESET);
            } else {
                for (Servico s : servicos) {
                    String servicosOferecidos = "";
                    if (s.getBANHO() == 1) servicosOferecidos += "Banho ";
                    if (s.getTOSA() == 1) servicosOferecidos += "Tosa";
                    System.out.printf("ID: %d | %s | R$ %.2f\n",
                            s.getIdSERVICO(), servicosOferecidos, s.getPRECO());
                }
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }

    private void buscarServicoPorId() {
        try {
            System.out.println(AZUL + "\n--- BUSCAR SERVIÇO POR ID ---" + RESET);
            System.out.print("ID do Serviço: ");
            int id = lerInteiro();

            Servico servico = servicoControl.buscarPorId(id);
            System.out.println(VERDE + "✅ Serviço encontrado:" + RESET);
            String servicosOferecidos = "";
            if (servico.getBANHO() == 1) servicosOferecidos += "Banho ";
            if (servico.getTOSA() == 1) servicosOferecidos += "Tosa";
            System.out.printf("ID: %d | %s | R$ %.2f\n",
                    servico.getIdSERVICO(), servicosOferecidos, servico.getPRECO());
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }

    private void atualizarServico() {
        try {
            System.out.println(AZUL + "\n--- ATUALIZAR SERVIÇO ---" + RESET);
            System.out.print("ID do Serviço: ");
            int id = lerInteiro();

            Servico servico = servicoControl.buscarPorId(id);
            System.out.print("Novo Preço: ");
            BigDecimal preco = new BigDecimal(scanner.nextLine());
            System.out.print("Oferece Banho? (1-Sim / 0-Não): ");
            int banho = lerInteiro();
            System.out.print("Oferece Tosa? (1-Sim / 0-Não): ");
            int tosa = lerInteiro();

            servicoControl.atualizarServico(id, preco, banho, tosa);
            System.out.println(VERDE + "✅ Serviço atualizado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }

    private void excluirServico() {
        try {
            System.out.println(AZUL + "\n--- EXCLUIR SERVIÇO ---" + RESET);
            System.out.print("ID do Serviço a excluir: ");
            int id = lerInteiro();

            System.out.print("Confirma exclusão? (s/n): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                servicoControl.deletarServico(id);
                System.out.println(VERDE + "✅ Serviço excluído com sucesso!" + RESET);
            } else {
                System.out.println(AMARELO + "Operação cancelada." + RESET);
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }

    // === FORNECEDORES ===
    private void menuFornecedores() {
        while (true) {
            limparTela();
            System.out.println(AZUL + "\n=== GERENCIAR FORNECEDORES ===" + RESET);
            System.out.println("1. ➕ Cadastrar Fornecedor");
            System.out.println("2. 📋 Listar Fornecedores");
            System.out.println("3. 🔍 Buscar Fornecedor por ID");
            System.out.println("4. ✏️ Atualizar Fornecedor");
            System.out.println("5. 🗑️ Excluir Fornecedor");
            System.out.println("0. ↩️ Voltar");
            System.out.print(AMARELO + "Escolha uma opção: " + RESET);

            int opcao = lerInteiro();

            switch (opcao) {
                case 1: cadastrarFornecedor(); break;
                case 2: listarFornecedores(); break;
                case 3: buscarFornecedorPorId(); break;
                case 4: atualizarFornecedor(); break;
                case 5: excluirFornecedor(); break;
                case 0: return;
                default: System.out.println(VERMELHO + "Opção inválida!" + RESET);
            }
        }
    }

    private void cadastrarFornecedor() {
        try {
            System.out.println(AZUL + "\n--- CADASTRAR FORNECEDOR ---" + RESET);
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();

            fornecedorControl.cadastrarFornecedor(nome, telefone, email);
            System.out.println(VERDE + "✅ Fornecedor cadastrado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }

    private void listarFornecedores() {
        try {
            System.out.println(AZUL + "\n--- LISTA DE FORNECEDORES ---" + RESET);
            List<Fornecedor> fornecedores = fornecedorControl.listarFornecedores();
            if (fornecedores.isEmpty()) {
                System.out.println(AMARELO + "Nenhum fornecedor cadastrado." + RESET);
            } else {
                for (Fornecedor f : fornecedores) {
                    System.out.printf("ID: %d | Nome: %s | Email: %s | Tel: %s\n",
                            f.getIdFORNECEDOR(), f.getNOME(), f.getEMAIL(), f.getTELEFONE());
                }
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }

    private void buscarFornecedorPorId() {
        try {
            System.out.println(AZUL + "\n--- BUSCAR FORNECEDOR POR ID ---" + RESET);
            System.out.print("ID do Fornecedor: ");
            int id = lerInteiro();

            Fornecedor fornecedor = fornecedorControl.buscarPorId(id);
            System.out.println(VERDE + "✅ Fornecedor encontrado:" + RESET);
            System.out.printf("ID: %d | Nome: %s | Email: %s | Tel: %s\n",
                    fornecedor.getIdFORNECEDOR(), fornecedor.getNOME(), fornecedor.getEMAIL(), fornecedor.getTELEFONE());
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }

    private void atualizarFornecedor() {
        try {
            System.out.println(AZUL + "\n--- ATUALIZAR FORNECEDOR ---" + RESET);
            System.out.print("ID do Fornecedor: ");
            int id = lerInteiro();

            Fornecedor fornecedor = fornecedorControl.buscarPorId(id);
            System.out.println("Fornecedor atual: " + fornecedor.getNOME());

            System.out.print("Novo Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novo Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Novo Email: ");
            String email = scanner.nextLine();

            fornecedorControl.atualizarFornecedor(id, nome, telefone, email);
            System.out.println(VERDE + "✅ Fornecedor atualizado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }

    private void excluirFornecedor() {
        try {
            System.out.println(AZUL + "\n--- EXCLUIR FORNECEDOR ---" + RESET);
            System.out.print("ID do Fornecedor a excluir: ");
            int id = lerInteiro();

            System.out.print("Confirma exclusão? (s/n): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                fornecedorControl.deletarFornecedor(id);
                System.out.println(VERDE + "✅ Fornecedor excluído com sucesso!" + RESET);
            } else {
                System.out.println(AMARELO + "Operação cancelada." + RESET);
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }

    // === COMPRAS ===
    private void menuCompras() {
        while (true) {
            limparTela();
            System.out.println(AZUL + "\n=== GERENCIAR COMPRAS ===" + RESET);
            System.out.println("1. 📋 Listar Compras");
            System.out.println("2. 🔍 Buscar Compra por ID");
            System.out.println("3. 👤 Buscar Compras por CPF");
            System.out.println("0. ↩️ Voltar");
            System.out.print(AMARELO + "Escolha uma opção: " + RESET);

            int opcao = lerInteiro();

            switch (opcao) {
                case 1: listarCompras(); break;
                case 2: buscarCompraPorId(); break;
                case 3: buscarComprasPorCpf(); break;
                case 0: return;
                default: System.out.println(VERMELHO + "Opção inválida!" + RESET);
            }
        }
    }

    private void listarCompras() {
        try {
            System.out.println(AZUL + "\n--- LISTA DE COMPRAS ---" + RESET);
            List<Compra> compras = compraControl.listarTodas();
            if (compras.isEmpty()) {
                System.out.println(AMARELO + "Nenhuma compra registrada." + RESET);
            } else {
                for (Compra c : compras) {
                    System.out.printf("ID: %d | CPF: %s | Data: %s | Valor: R$ %.2f\n",
                            c.getIdCOMPRA(), c.getCPF(), c.getDATA_COMPRA(), c.getVALOR_TOTAL());
                }
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }

    private void buscarCompraPorId() {
        try {
            System.out.println(AZUL + "\n--- BUSCAR COMPRA POR ID ---" + RESET);
            System.out.print("ID da Compra: ");
            int id = lerInteiro();

            Compra compra = compraControl.buscarPorId(id);
            System.out.println(VERDE + "✅ Compra encontrada:" + RESET);
            System.out.printf("ID: %d | CPF: %s | Data: %s | Valor: R$ %.2f\n",
                    compra.getIdCOMPRA(), compra.getCPF(), compra.getDATA_COMPRA(), compra.getVALOR_TOTAL());
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }

    private void buscarComprasPorCpf() {
        try {
            System.out.println(AZUL + "\n--- BUSCAR COMPRAS POR CPF ---" + RESET);
            System.out.print("CPF do Cliente: ");
            String cpf = scanner.nextLine();

            List<Compra> compras = compraControl.buscarPorCpf(cpf);
            if (compras.isEmpty()) {
                System.out.println(AMARELO + "Nenhuma compra encontrada para este CPF." + RESET);
            } else {
                System.out.println(VERDE + "✅ Compras encontradas:" + RESET);
                for (Compra c : compras) {
                    System.out.printf("ID: %d | Data: %s | Valor: R$ %.2f\n",
                            c.getIdCOMPRA(), c.getDATA_COMPRA(), c.getVALOR_TOTAL());
                }
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }

    // === ADMINISTRADORES ===
    private void menuAdministradores() {
        while (true) {
            limparTela();
            System.out.println(AZUL + "\n=== GERENCIAR ADMINISTRADORES ===" + RESET);
            System.out.println("1. ➕ Cadastrar Administrador");
            System.out.println("2. 📋 Listar Administradores");
            System.out.println("3. 🔍 Buscar Administrador por ID");
            System.out.println("4. ✏️ Atualizar Administrador");
            System.out.println("5. 🗑️ Excluir Administrador");
            System.out.println("0. ↩️ Voltar");
            System.out.print(AMARELO + "Escolha uma opção: " + RESET);

            int opcao = lerInteiro();

            switch (opcao) {
                case 1: cadastrarAdministrador(); break;
                case 2: listarAdministradores(); break;
                case 3: buscarAdministradorPorId(); break;
                case 4: atualizarAdministrador(); break;
                case 5: excluirAdministrador(); break;
                case 0: return;
                default: System.out.println(VERMELHO + "Opção inválida!" + RESET);
            }
        }
    }

    private void cadastrarAdministrador() {
        try {
            System.out.println(AZUL + "\n--- CADASTRAR ADMINISTRADOR ---" + RESET);
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Login: ");
            String login = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            Administrador admin = new Administrador(0, nome, login, senha);
            adminControl.cadastrarAdministrador(admin);
            System.out.println(VERDE + "✅ Administrador cadastrado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }

    private void listarAdministradores() {
        try {
            System.out.println(AZUL + "\n--- LISTA DE ADMINISTRADORES ---" + RESET);
            List<Administrador> admins = adminControl.listarAdministradores();
            if (admins.isEmpty()) {
                System.out.println(AMARELO + "Nenhum administrador cadastrado." + RESET);
            } else {
                for (Administrador a : admins) {
                    System.out.printf("ID: %d | Nome: %s | Login: %s\n",
                            a.getIdADMINISTRADOR(), a.getNOME(), a.getLOGIN());
                }
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }

    private void buscarAdministradorPorId() {
        try {
            System.out.println(AZUL + "\n--- BUSCAR ADMINISTRADOR POR ID ---" + RESET);
            System.out.print("ID do Administrador: ");
            int id = lerInteiro();

            Administrador admin = adminControl.buscarPorId(id);
            System.out.println(VERDE + "✅ Administrador encontrado:" + RESET);
            System.out.printf("ID: %d | Nome: %s | Login: %s\n",
                    admin.getIdADMINISTRADOR(), admin.getNOME(), admin.getLOGIN());
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }

    private void atualizarAdministrador() {
        try {
            System.out.println(AZUL + "\n--- ATUALIZAR ADMINISTRADOR ---" + RESET);
            System.out.print("ID do Administrador: ");
            int id = lerInteiro();

            Administrador admin = adminControl.buscarPorId(id);
            System.out.println("Administrador atual: " + admin.getNOME());

            System.out.print("Novo Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novo Login: ");
            String login = scanner.nextLine();
            System.out.print("Nova Senha: ");
            String senha = scanner.nextLine();

            admin.setNOME(nome);
            admin.setLOGIN(login);
            admin.setSENHA(senha);

            adminControl.atualizarAdministrador(admin);
            System.out.println(VERDE + "✅ Administrador atualizado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }

    private void excluirAdministrador() {
        try {
            System.out.println(AZUL + "\n--- EXCLUIR ADMINISTRADOR ---" + RESET);
            System.out.print("ID do Administrador a excluir: ");
            int id = lerInteiro();

            // Não permitir excluir a si mesmo
            Administrador adminAtual = adminControl.buscarPorId(id);
            if (adminAtual != null) {
                System.out.println("Você está prestes a excluir: " + adminAtual.getNOME());
            }

            System.out.print("Confirma exclusão? (s/n): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                adminControl.deletarAdministrador(id);
                System.out.println(VERDE + "✅ Administrador excluído com sucesso!" + RESET);
            } else {
                System.out.println(AMARELO + "Operação cancelada." + RESET);
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }

    // === PAGAMENTOS PIX ===
    private void menuPagamentosPix() {
        while (true) {
            limparTela();
            System.out.println(AZUL + "\n=== GERENCIAR PAGAMENTOS PIX ===" + RESET);
            System.out.println("1. ➕ Cadastrar Pagamento PIX");
            System.out.println("2. 📋 Listar Pagamentos PIX");
            System.out.println("3. 🔍 Buscar Pagamento por ID");
            System.out.println("4. 🔑 Buscar por Chave PIX");
            System.out.println("5. ✏️ Atualizar Pagamento");
            System.out.println("6. 🗑️ Excluir Pagamento");
            System.out.println("0. ↩️ Voltar");
            System.out.print(AMARELO + "Escolha uma opção: " + RESET);

            int opcao = lerInteiro();

            switch (opcao) {
                case 1: cadastrarPagamentoPix(); break;
                case 2: listarPagamentosPix(); break;
                case 3: buscarPagamentoPixPorId(); break;
                case 4: buscarPagamentoPorChavePix(); break;
                case 5: atualizarPagamentoPix(); break;
                case 6: excluirPagamentoPix(); break;
                case 0: return;
                default: System.out.println(VERMELHO + "Opção inválida!" + RESET);
            }
        }
    }

    private void cadastrarPagamentoPix() {
        try {
            System.out.println(AZUL + "\n--- CADASTRAR PAGAMENTO PIX ---" + RESET);
            System.out.print("ID do Pagamento: ");
            int id = lerInteiro();
            System.out.print("Chave PIX: ");
            String chavePix = scanner.nextLine();
            System.out.print("ID da Compra: ");
            int idCompra = lerInteiro();

            pagamentoPixControl.cadastrarPagamento(id, chavePix, idCompra);
            System.out.println(VERDE + "✅ Pagamento PIX cadastrado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }

    private void listarPagamentosPix() {
        try {
            System.out.println(AZUL + "\n--- LISTA DE PAGAMENTOS PIX ---" + RESET);
            List<PagamentoPix> pagamentos = pagamentoPixControl.listarPagamentos();
            if (pagamentos.isEmpty()) {
                System.out.println(AMARELO + "Nenhum pagamento PIX cadastrado." + RESET);
            } else {
                for (PagamentoPix p : pagamentos) {
                    System.out.printf("ID: %d | Chave: %s | ID Compra: %d\n",
                            p.getIdPAGAMENTO_PIX(), p.getCHAVE_PIX(), p.getID_COMPRA());
                }
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }

    private void buscarPagamentoPixPorId() {
        try {
            System.out.println(AZUL + "\n--- BUSCAR PAGAMENTO PIX POR ID ---" + RESET);
            System.out.print("ID do Pagamento: ");
            int id = lerInteiro();

            PagamentoPix pagamento = pagamentoPixControl.buscarPorId(id);
            System.out.println(VERDE + "✅ Pagamento encontrado:" + RESET);
            System.out.printf("ID: %d | Chave: %s | ID Compra: %d\n",
                    pagamento.getIdPAGAMENTO_PIX(), pagamento.getCHAVE_PIX(), pagamento.getID_COMPRA());
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }

    private void buscarPagamentoPorChavePix() {
        try {
            System.out.println(AZUL + "\n--- BUSCAR PAGAMENTO POR CHAVE PIX ---" + RESET);
            System.out.print("Chave PIX: ");
            String chavePix = scanner.nextLine();

            PagamentoPix pagamento = pagamentoPixControl.buscarPorChavePix(chavePix);
            System.out.println(VERDE + "✅ Pagamento encontrado:" + RESET);
            System.out.printf("ID: %d | Chave: %s | ID Compra: %d\n",
                    pagamento.getIdPAGAMENTO_PIX(), pagamento.getCHAVE_PIX(), pagamento.getID_COMPRA());
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(3);
    }

    private void atualizarPagamentoPix() {
        try {
            System.out.println(AZUL + "\n--- ATUALIZAR PAGAMENTO PIX ---" + RESET);
            System.out.print("ID do Pagamento: ");
            int id = lerInteiro();

            PagamentoPix pagamento = pagamentoPixControl.buscarPorId(id);
            System.out.println("Pagamento atual - Chave: " + pagamento.getCHAVE_PIX());

            System.out.print("Nova Chave PIX: ");
            String novaChave = scanner.nextLine();
            System.out.print("Novo ID da Compra: ");
            int novoIdCompra = lerInteiro();

            pagamentoPixControl.atualizarPagamento(id, novaChave, novoIdCompra);
            System.out.println(VERDE + "✅ Pagamento PIX atualizado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }

    private void excluirPagamentoPix() {
        try {
            System.out.println(AZUL + "\n--- EXCLUIR PAGAMENTO PIX ---" + RESET);
            System.out.print("ID do Pagamento a excluir: ");
            int id = lerInteiro();

            System.out.print("Confirma exclusão? (s/n): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                pagamentoPixControl.deletarPagamento(id);
                System.out.println(VERDE + "✅ Pagamento PIX excluído com sucesso!" + RESET);
            } else {
                System.out.println(AMARELO + "Operação cancelada." + RESET);
            }
        } catch (Exception e) {
            System.out.println(VERMELHO + "❌ Erro: " + e.getMessage() + RESET);
        }
        pausa(2);
    }
    
    // ========== UTILITÁRIOS ==========
    private int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print(VERMELHO + "Por favor, digite um número válido: " + RESET);
            }
        }
    }
    
    private void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            // Se não conseguir limpar a tela, apenas imprime várias linhas
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
    
    private void pausa(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    // Método main para executar a aplicação
    public static void main(String[] args) {
        PetPlace petPlace = new PetPlace();
        petPlace.iniciar();
    }
}