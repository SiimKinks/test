import RxSwift

protocol AccountStore {
    func observeAllAccounts(for customerId: CustomerId) -> Observable<[Account]>
}
