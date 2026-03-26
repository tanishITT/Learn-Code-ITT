package com.orchestration.main;

import com.orchestration.condition.InputLengthExceedsCondition;
import com.orchestration.core.StepCondition;
import com.orchestration.core.WorkflowStep;
import com.orchestration.core.WorkflowTracer;
import com.orchestration.decorator.ConditionalWorkflowStep;
import com.orchestration.decorator.FallbackWorkflowStep;
import com.orchestration.decorator.RetryableWorkflowStep;
import com.orchestration.step.*;
import com.orchestration.tracer.ConsoleWorkflowTracer;
import com.orchestration.workflow.WorkflowDefinition;
import com.orchestration.workflow.WorkflowDefinitionBuilder;
import com.orchestration.workflow.WorkflowExecutionResult;
import com.orchestration.workflow.WorkflowOrchestrator;

public class Application {

    private static final int CONDITIONAL_TRANSLATION_MIN_LENGTH = 50;
    private static final int CSV_PIPELINE_MAX_RETRY_ATTEMPTS = 3;

    public static void main(String[] args) {
        WorkflowTracer tracer = new ConsoleWorkflowTracer();
        WorkflowOrchestrator orchestrator = new WorkflowOrchestrator(tracer);

        runProductDescriptionPipeline(orchestrator);
        runCsvInsightsPipeline(orchestrator);
        runUserQueryPipeline(orchestrator);
    }

    private static void runProductDescriptionPipeline(WorkflowOrchestrator orchestrator) {
        WorkflowDefinition productDescriptionWorkflow = new WorkflowDefinitionBuilder()
            .withName("ProductDescriptionPipeline")
            .addStep(new ContentGenerationStep("GPT-4o-simulator"))
            .addStep(new ToneRefinementStep("Professional"))
            .addStep(new SummarizationStep())
            .addStep(new TranslationStep("French"))
            .build();

        WorkflowExecutionResult result = orchestrator.execute(
            productDescriptionWorkflow,
            "Ultra-light carbon fibre running shoes with adaptive sole technology"
        );

        printResult(result);
    }

    private static void runCsvInsightsPipeline(WorkflowOrchestrator orchestrator) {
        WorkflowStep retryableGenerationStep = new RetryableWorkflowStep(
            new ContentGenerationStep("Claude-3-something-something"),
            CSV_PIPELINE_MAX_RETRY_ATTEMPTS
        );

        WorkflowStep postProcessWithFallbackStep = new FallbackWorkflowStep(
            new PostProcessingStep(),
            new SummarizationStep()
        );

        WorkflowDefinition csvInsightsWorkflow = new WorkflowDefinitionBuilder()
            .withName("CsvInsightsPipeline")
            .addStep(new CsvAnalysisStep())
            .addStep(new ContextEnrichmentStep("InternalKnowledgeBase"))
            .addStep(retryableGenerationStep)
            .addStep(postProcessWithFallbackStep)
            .build();

        WorkflowExecutionResult result = orchestrator.execute(
            csvInsightsWorkflow,
            "revenue,units_sold,region,quarter,year"
        );

        printResult(result);
    }

    private static void runUserQueryPipeline(WorkflowOrchestrator orchestrator) {
        StepCondition outputIsLongEnough =
            new InputLengthExceedsCondition(CONDITIONAL_TRANSLATION_MIN_LENGTH);

        WorkflowStep conditionalTranslationStep = new ConditionalWorkflowStep(
            new TranslationStep("Spanish"),
            outputIsLongEnough
        );

        WorkflowDefinition userQueryWorkflow = new WorkflowDefinitionBuilder()
            .withName("UserQueryPipeline")
            .addStep(new ContextEnrichmentStep("UserProfileService"))
            .addStep(new ContentGenerationStep("Tanish-1.5-Pro"))
            .addStep(new PostProcessingStep())
            .addStep(conditionalTranslationStep)
            .build();

        WorkflowExecutionResult result = orchestrator.execute(
            userQueryWorkflow,
            "What are the best practices for REST API design?"
        );

        printResult(result);
    }


    private static void printResult(WorkflowExecutionResult result) {
        System.out.println("\n================================================");
        if (result.isSuccessful()) {
            System.out.println("STATUS : SUCCESS");
            System.out.println("OUTPUT : " + result.getFinalOutput().orElse("(none)"));
        } else {
            System.out.println("STATUS : FAILED");
            System.out.println("REASON : " + result.getFailureReason().orElse("(unknown)"));
        }
        System.out.println("================================================\n");
    }
}
