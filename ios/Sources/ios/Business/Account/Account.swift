typealias AccountId = String
typealias Iban = String
typealias MonetaryNumber = String

protocol AccountInfo {
    var iban: Iban { get }
    var alias: String? { get }
    var name: String { get }
}

protocol BaseAccount: AccountInfo {
    var accountId: AccountId { get }
    var customerId: CustomerId { get }
    var isDefault: Bool { get }
    var balanceCount: Int { get }
    var isPaymentAllowed: Bool { get }
}

enum AccountType {
    case current, credit, savings
}

@dynamicMemberLookup
enum Account: Equatable {
    case current(CurrentAccount)
    case savings(SavingsAccount)
    
    subscript<T>(dynamicMember keyPath: KeyPath<BaseAccount, T>) -> T {
        switch self {
        case let .current(account):
            return account[keyPath: keyPath]
        case let .savings(account):
            return account[keyPath: keyPath]
        }
    }
    
    var isSavingsAccount: Bool {
        if case .savings = self {
            return true
        }
        return false
    }
}

struct CurrentAccount: BaseAccount, Equatable {
    let accountId: AccountId
    let customerId: CustomerId
    let isDefault: Bool
    let balanceCount: Int
    let isPaymentAllowed: Bool
    let iban: Iban
    let alias: String?
}

struct SavingsAccount: BaseAccount, Equatable {
    let accountId: AccountId
    let customerId: CustomerId
    let isDefault: Bool
    let balanceCount: Int
    let isPaymentAllowed: Bool
    let iban: Iban
    let alias: String?
    let goal: SavingsGoal?
    let isRoundUpEnabled: Bool
    
    var name: String { goal?.description ?? alias ?? iban }
}

struct SavingsGoal: Equatable {
    let amount: MonetaryNumber?
    let description: String?
}

extension AccountInfo {
    var name: String { alias ?? iban }
}
