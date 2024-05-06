/// Single functional piece of business logic.
///
/// Input data comes from DI.
///
/// - Parameter OutputType: Use case produced data type
public typealias UseCase<OutputType> = () -> OutputType

/// Single functional piece of business logic that reacts to input data.
///
/// Input data comes from DI.
///
/// - Parameter InputType: Input data type
/// - Parameter OutputType: Use case produced data type
public typealias InteractionUseCase<InputType, OutputType> = (InputType) -> OutputType
