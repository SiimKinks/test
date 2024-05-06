import Foundation
import RxSwift

protocol SavingsStore {
    /// - Parameter accountIds: Array of account ids to get savings account images for. Cannot be empty!
    func observeSavingsAccountImages(for accountIds: [AccountId]) -> Observable<[AccountId: Data]>
}
