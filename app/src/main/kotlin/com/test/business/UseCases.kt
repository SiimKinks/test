package com.test.business

/**
 * Single functional piece of business logic.
 *
 * Input data comes from DI.
 *
 * @param OutputType Use case produced data type
 */
interface UseCase<OutputType> : () -> OutputType

/**
 * Single functional piece of business logic that reacts to input data.
 *
 * @param InputType Input data type
 * @param OutputType Use case produced data type
 */
interface InteractionUseCase<InputType, OutputType> : (InputType) -> OutputType
